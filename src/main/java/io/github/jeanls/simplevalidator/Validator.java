package io.github.jeanls.simplevalidator;

import io.github.jeanls.simplevalidator.booleanrules.BooleanRule;
import io.github.jeanls.simplevalidator.commonrules.Rule;
import io.github.jeanls.simplevalidator.daterules.LocalDateRule;
import io.github.jeanls.simplevalidator.daterules.LocalDateTimeRule;
import io.github.jeanls.simplevalidator.listrules.ListRule;
import io.github.jeanls.simplevalidator.numberrules.NumberRule;
import io.github.jeanls.simplevalidator.objectrules.ObjectRule;
import io.github.jeanls.simplevalidator.stringrules.CharSequenceRule;
import io.github.jeanls.simplevalidator.utils.Bundle;
import io.github.jeanls.simplevalidator.validation.ValidationCapsule;
import io.github.jeanls.simplevalidator.validation.ValidationError;
import io.github.jeanls.simplevalidator.validation.ValidationItemList;
import io.github.jeanls.simplevalidator.validation.ValidationResult;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public abstract class Validator<D> {
    private List<RuleItem<D, Object>> ruleItems = new ArrayList<>();
    private List<ValidationCapsule<D, ?>> validationCapsules = new ArrayList<>();
    private List<ValidationItemList<D, ?, ?>> validationItemLists = new ArrayList<>();

    public Validator<D> addCharSequenceRule(final Function<D, CharSequence> field, final String fieldName, final UnaryOperator<CharSequenceRule<CharSequence>> rule) {
        this.addRule(field, fieldName, rule, CharSequenceRule::new);
        return this;
    }

    public Validator<D> addNumberRule(final Function<D, Number> field, final String fieldName, final UnaryOperator<NumberRule<Number>> rule) {
        this.addRule(field, fieldName, rule, NumberRule::new);
        return this;
    }

    public Validator<D> addBooleanRule(final Function<D, Boolean> field, final String fieldName, final UnaryOperator<BooleanRule> rule) {
        this.addRule(field, fieldName, rule, BooleanRule::new);
        return this;
    }

    public <O> Validator<D> addObjectRule(final Function<D, O> field, final String fieldName, final UnaryOperator<ObjectRule<O>> rule) {
        this.addRule(field, fieldName, rule, ObjectRule::new);
        return this;
    }

    public Validator<D> addLocalDateRule(final Function<D, LocalDate> field, final String fieldName, final UnaryOperator<LocalDateRule> rule) {
        this.addRule(field, fieldName, rule, LocalDateRule::new);
        return this;
    }

    public <L extends List<I>, I> Validator<D> addListRule(final Function<D, L> field, final String fieldName, final UnaryOperator<ListRule<L, I>> rule) {
        this.addRule(field, fieldName, rule, ListRule::new);
        return this;
    }

    public Validator<D> addLocalDateTimeRule(final Function<D, LocalDateTime> field, final String fieldName, final UnaryOperator<LocalDateTimeRule> rule) {
        this.addRule(field, fieldName, rule, LocalDateTimeRule::new);
        return this;
    }

    public <V, R extends Rule<V>> Validator<D> addCustomRule(final Function<D, V> field, final String fieldName, Supplier<R> supplier, UnaryOperator<R> rule) {
        this.addRule(field, fieldName, rule, supplier);
        return this;
    }

    private <V, R extends Rule<V>> void addRule(final Function<D, V> field, final String fieldName, final UnaryOperator<R> ruleFn, final Supplier<R> ruleInstance) {
        final R rule = ruleInstance.get();
        this.ruleItems.add(new RuleItem(ruleFn.apply(rule).getRules(), fieldName, field));
    }

    public ValidationResult run(D d) {
        return runValidation(d, true, "");
    }

    public ValidationResult run(D d, boolean validateIfNull, String fieldName) {
        return runValidation(d, validateIfNull, fieldName);
    }

    public ValidationResult run(D d, String fieldName) {
        return runValidation(d, true, fieldName);
    }

    public ValidationResult run(D d, boolean validateIfNull) {
        return runValidation(d, validateIfNull, "");
    }

    private synchronized ValidationResult runValidation(D d, boolean validateIfNull, String fieldName) {
        try {
            if (d == null && validateIfNull) {
                return new ValidationResult(false, Collections.singletonList(new ValidationError(fieldName, null, Bundle.getInstance().get("notNull", null))));
            }

            if (d == null) {
                return new ValidationResult(true, Collections.emptyList());
            }

            final List<ValidationError> errors = new ArrayList<>();
            boolean isValid = true;
            for (final RuleItem<D, Object> ruleItem : ruleItems) {
                for (RulePredicate<Object> rulePredicate : ruleItem.getPredicates()) {
                    final Object o = ruleItem.getField().apply(d);
                    final boolean result = rulePredicate.getPredicate().test(o);
                    if (!result) {
                        isValid = false;
                        errors.add(new ValidationError(ruleItem.getFieldName(), o, rulePredicate.getMessage()));
                    }
                }
            }
            for (final ValidationCapsule<D, ?> validationCapsule : this.validationCapsules) {
                final Validator validator = validationCapsule.getValidator();
                final Object instance = validationCapsule.getInstance().apply(d);
                final ValidationResult validationResult = validator.validate(instance);
                isValid = (isValid && validationResult.isValid());
                errors.addAll(validationResult.getErrors());
            }
            for (final ValidationItemList<D, ?, ?> validationItemList : validationItemLists) {
                final List<?> list = validationItemList.getItem().apply(d);
                final Validator validator = validationItemList.getValidator();
                for (int x = 0; x < list.size(); x++) {
                    final Object instance = list.get(x);
                    final ValidationResult validationResult = validator.validate(instance);
                    if (!validationResult.isValid()) {
                        for (final ValidationError error : validationResult.getErrors()) {
                            error.setMessage(String.format("[%s] %s", x, error.getMessage()));
                            error.setFieldName(String.format("%s.[%s]", error.getFieldName(), x));
                        }
                    }
                    isValid = (isValid && validationResult.isValid());
                    errors.addAll(validationResult.getErrors());
                }
            }
            return new ValidationResult(isValid, errors);
        } finally {
            ruleItems = new ArrayList<>();
            validationCapsules = new ArrayList<>();
            validationItemLists = new ArrayList<>();
        }
    }

    public abstract ValidationResult validate(D obj);

    public <V> Validator<D> addValidator(final Function<D, V> field, final Validator<V> validator) {
        final ValidationCapsule<D, V> validationCapsule = new ValidationCapsule<>(validator, field);
        validationCapsules.add(validationCapsule);
        return this;
    }

    public <V extends List<I>, I> Validator<D> addItemListValidator(final Function<D, V> listField, final Validator<I> validator) {
        final ValidationItemList<D, V, I> validationItemList = new ValidationItemList<>(validator, listField);
        this.validationItemLists.add(validationItemList);
        return this;
    }
}
