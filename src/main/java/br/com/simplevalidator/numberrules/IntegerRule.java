package br.com.simplevalidator.numberrules;

import br.com.simplevalidator.RulePredicate;
import br.com.simplevalidator.commonrules.Rule;
import br.com.simplevalidator.utils.Bundle;

import java.util.function.Predicate;

public class IntegerRule<F extends Number> extends Rule<F> {

    public IntegerRule<F> lessThan(final Integer val, final String... message) {
        final Predicate<F> predicate = e -> isNotNull(e) && ((Integer) e) < val;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("lessThan", message, val)));
        return this;
    }

    public IntegerRule<F> lessThanOrEquals(final Integer val, final String... message) {
        final Predicate<F> predicate = e -> isNotNull(e) && ((Integer) e) <= val;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("lessThanOrEquals", message, val)));
        return this;
    }

    public IntegerRule<F> greaterThan(final Integer val, final String... message) {
        final Predicate<F> predicate = e -> isNotNull(e) && ((Integer) e) > val;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("greaterThan", message, val)));
        return this;
    }

    public IntegerRule<F> greaterThanOrEquals(final Integer val, final String... message) {
        final Predicate<F> predicate = e -> isNotNull(e) && ((Integer) e) >= val;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("greaterThanOrEquals", message, val)));
        return this;
    }

    public IntegerRule<F> notNull(final String... message) {
        final Predicate<F> predicate = this::isNotNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notNull", message)));
        return this;
    }

    public IntegerRule<F> isPositive(final String... message) {
        final Predicate<F> predicate = e -> isNotNull(e) && ((Integer) e) > 0;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isPositive", message)));
        return this;
    }

    public IntegerRule<F> isPositiveOrZero(final String... message) {
        final Predicate<F> predicate = e -> isNotNull(e) && ((Integer) e) >= 0;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isPositiveOrZero", message)));
        return this;
    }

    public IntegerRule<F> isNegative(final String... message) {
        final Predicate<F> predicate = e -> isNotNull(e) && ((Integer) e) < 0;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isNegative", message)));
        return this;
    }

    public IntegerRule<F> isNegativeOrZero(final String... message) {
        final Predicate<F> predicate = e -> isNotNull(e) && ((Integer) e) <= 0;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isNegativeOrZero", message)));
        return this;
    }

    private boolean isNotNull(F f) {
        return f != null;
    }
}
