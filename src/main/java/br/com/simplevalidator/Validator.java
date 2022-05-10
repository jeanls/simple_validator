package br.com.simplevalidator;

import br.com.simplevalidator.commonrules.Rule;
import br.com.simplevalidator.customrule.CustomRule;
import br.com.simplevalidator.numberrules.IntegerRule;
import br.com.simplevalidator.objectrules.ObjectRule;
import br.com.simplevalidator.stringrules.CharSequenceRule;
import br.com.simplevalidator.validation.ValidationCapsule;
import br.com.simplevalidator.validation.ValidationError;
import br.com.simplevalidator.validation.ValidationResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public abstract class Validator<D> {
    private final List<RuleItem<D, Object>> ruleItems = new ArrayList<>();
    private final List<ValidationCapsule<?>> validationCapsules = new ArrayList<>();

    public Validator<D> addCharSequenceRule(final Function<D, CharSequence> field, final String fieldName, final UnaryOperator<CharSequenceRule<CharSequence>> rule) {
        this.addRule(field, fieldName, rule, CharSequenceRule::new);
        return this;
    }

    public Validator<D> addIntegerRule(final Function<D, Number> field, final String fieldName, final UnaryOperator<IntegerRule<Number>> rule) {
        this.addRule(field, fieldName, rule, IntegerRule::new);
        return this;
    }

    public <O> Validator<D> addObjectRule(final Function<D, O> field, final String fieldName, final UnaryOperator<ObjectRule<O>> rule) {
        this.addRule(field, fieldName, rule, ObjectRule::new);
        return this;
    }

    public <V, R extends CustomRule<V, R>> Validator<D> addCustomRule(Function<D, V> field, final String fieldName, Supplier<R> supplier, UnaryOperator<R> rule) {
        this.addRule(field, fieldName, rule, supplier);
        return this;
    }

    private <V, R extends Rule<V>> void addRule(Function<D, V> field, final String fieldName, UnaryOperator<R> ruleFn, Supplier<R> ruleInstance) {
        R rule = ruleInstance.get();
        this.ruleItems.add(new RuleItem(ruleFn.apply(rule).getRules(), fieldName, field));
    }

    public ValidationResult run(D d) {
        if (d == null) {
            return new ValidationResult(false, Collections.emptyList());
        }
        final List<ValidationError> errors = new ArrayList<>();
        AtomicBoolean isValid = new AtomicBoolean(true);
        this.ruleItems.forEach(ruleItem -> ruleItem.getPredicates().forEach(rulePredicate -> {
            final Object o = ruleItem.getField().apply(d);
            final boolean result = rulePredicate.getPredicate().test(o);
            if (!result) {
                isValid.set(false);
                errors.add(new ValidationError(ruleItem.getFieldName(), o, rulePredicate.getMessage()));
            }
        }));
        this.validationCapsules.forEach(validationCapsule -> {
            final Validator validator = validationCapsule.getValidator();
            final ValidationResult validationResult = validator.validate(validationCapsule.getInstance());
            isValid.set(isValid.get() && validationResult.isValid());
            errors.addAll(validationResult.getErrors());
        });
        return new ValidationResult(isValid.get(), errors);
    }

    public abstract ValidationResult validate(D obj);

    public <V> Validator<D> addValidator(final Validator<V> validator, final V v) {
        final ValidationCapsule<V> validationCapsule = new ValidationCapsule<>(validator, v);
        validationCapsules.add(validationCapsule);
        return this;
    }
}

/*
* nos ruiles tem que haver sua contraparte
* */
