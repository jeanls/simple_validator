package br.com.simplevalidator;

import br.com.simplevalidator.commonrules.Rule;
import br.com.simplevalidator.customrule.CustomRule;
import br.com.simplevalidator.stringrules.CharSequenceRule;
import br.com.simplevalidator.validation.ValidationError;
import br.com.simplevalidator.validation.ValidationResult;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public abstract class Validator<D> {

    final List<RuleItem<D, Object>> ruleItems = new ArrayList<>();

    protected Validator<D> addCharSequenceRule(Function<D, CharSequence> field, String fieldName, UnaryOperator<CharSequenceRule<CharSequence>> rule) {
        this.addRule(field, fieldName, rule, CharSequenceRule::new);
        return this;
    }

    protected <V, R extends CustomRule<V, R>> Validator<D> addCustomRule(Function<D, V> field, final String fieldName, Supplier<R> supplier, UnaryOperator<R> rule) {
        this.addRule(field, fieldName, rule, supplier);
        return this;
    }

    private <V, R extends Rule<V>> void addRule(Function<D, V> field, final String fieldName, UnaryOperator<R> ruleFn, Supplier<R> ruleInstance) {
        R rule = ruleInstance.get();
        this.ruleItems.add(new RuleItem(ruleFn.apply(rule).getRules(), fieldName, field));
    }

    public ValidationResult run(D d) {
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
        return new ValidationResult(isValid.get(), errors);
    }
}

//TODO add rules de uma lista
