package br.com.simplevalidator.booleanrules;

import br.com.simplevalidator.RulePredicate;
import br.com.simplevalidator.commonrules.Rule;
import br.com.simplevalidator.utils.Bundle;

import java.util.Objects;
import java.util.function.Predicate;

public class BooleanRule<T extends Boolean> extends Rule<T> {

    public BooleanRule<T> equalsTo(final boolean value, final String... message) {
        final Predicate<T> predicate = t -> Objects.nonNull(t) && Boolean.valueOf(t) == value;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isTrue", message)));
        return this;
    }

    public BooleanRule<T> notEqualsTo(final boolean value, final String... message) {
        final Predicate<T> predicate = t -> Objects.nonNull(t) && Boolean.valueOf(t) != value;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isTrue", message)));
        return this;
    }

    public BooleanRule<T> isNull(final String... message) {
        final Predicate<T> predicate = Objects::isNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isNull", message)));
        return this;
    }

    public BooleanRule<T> notNull(final String... message) {
        final Predicate<T> predicate = Objects::nonNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notNull", message)));
        return this;
    }

    public BooleanRule<T> isTrue(final String... message) {
        final Predicate<T> predicate = t -> Objects.nonNull(t) && Boolean.valueOf(t);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isTrue", message)));
        return this;
    }

    public BooleanRule<T> isFalse(final String... message) {
        final Predicate<T> predicate = t -> Objects.nonNull(t) && !Boolean.valueOf(t);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isFalse", message)));
        return this;
    }
}
