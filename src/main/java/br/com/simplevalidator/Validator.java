package br.com.simplevalidator;

import br.com.simplevalidator.booleanrules.BooleanRule;
import br.com.simplevalidator.commonrules.Rule;
import br.com.simplevalidator.customrule.CustomRule;
import br.com.simplevalidator.daterules.LocalDateRule;
import br.com.simplevalidator.daterules.LocalDateTimeRule;
import br.com.simplevalidator.numberrules.NumberRule;
import br.com.simplevalidator.objectrules.ObjectRule;
import br.com.simplevalidator.stringrules.CharSequenceRule;
import br.com.simplevalidator.validation.ValidationCapsule;
import br.com.simplevalidator.validation.ValidationError;
import br.com.simplevalidator.validation.ValidationResult;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public abstract class Validator<D> {
    private final List<RuleItem<D, Object>> ruleItems = new ArrayList<>();
    private final List<ValidationCapsule<D, ?>> validationCapsules = new ArrayList<>();

    public Validator<D> addCharSequenceRule(final Function<D, CharSequence> field, final String fieldName, final UnaryOperator<CharSequenceRule<CharSequence>> rule) {
        this.addRule(field, fieldName, rule, CharSequenceRule::new);
        return this;
    }

    public Validator<D> addNumberRule(final Function<D, Number> field, final String fieldName, final UnaryOperator<NumberRule<Number>> rule) {
        this.addRule(field, fieldName, rule, NumberRule::new);
        return this;
    }

    public Validator<D> addBooleanRule(final Function<D, Boolean> field, final String fieldName, final UnaryOperator<BooleanRule<Boolean>> rule) {
        this.addRule(field, fieldName, rule, BooleanRule::new);
        return this;
    }

    public <O> Validator<D> addObjectRule(final Function<D, O> field, final String fieldName, final UnaryOperator<ObjectRule<O>> rule) {
        this.addRule(field, fieldName, rule, ObjectRule::new);
        return this;
    }

    public Validator<D> addLocalDateRule(final Function<D, LocalDate> field, final String fieldName, final UnaryOperator<LocalDateRule<LocalDate>> rule) {
        this.addRule(field, fieldName, rule, LocalDateRule::new);
        return this;
    }

    public Validator<D> addLocalDateTimeRule(final Function<D, LocalDateTime> field, final String fieldName, final UnaryOperator<LocalDateTimeRule<LocalDateTime>> rule) {
        this.addRule(field, fieldName, rule, LocalDateTimeRule::new);
        return this;
    }

    public <V, R extends CustomRule<V, R>> Validator<D> addCustomRule(final Function<D, V> field, final String fieldName, Supplier<R> supplier, UnaryOperator<R> rule) {
        this.addRule(field, fieldName, rule, supplier);
        return this;
    }

    private <V, R extends Rule<V>> void addRule(final Function<D, V> field, final String fieldName, final UnaryOperator<R> ruleFn, final Supplier<R> ruleInstance) {
        final R rule = ruleInstance.get();
        this.ruleItems.add(new RuleItem(ruleFn.apply(rule).getRules(), fieldName, field));
    }

    public ValidationResult run(D d) {
        if (d == null) {
            return new ValidationResult(false, Collections.emptyList());
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
        return new ValidationResult(isValid, errors);
    }

    public abstract ValidationResult validate(D obj);

    public <V> Validator<D> addValidator(final Function<D, V> field, final Validator<V> validator) {
        final ValidationCapsule<D, V> validationCapsule = new ValidationCapsule<>(validator, field);
        validationCapsules.add(validationCapsule);
        return this;
    }
}
