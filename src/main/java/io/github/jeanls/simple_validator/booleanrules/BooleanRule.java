package io.github.jeanls.simple_validator.booleanrules;

import io.github.jeanls.simple_validator.RulePredicate;
import io.github.jeanls.simple_validator.commonrules.Rule;
import io.github.jeanls.simple_validator.utils.Bundle;

import java.util.Objects;
import java.util.function.Predicate;

public class BooleanRule<T extends Boolean> extends Rule<T> {

    public BooleanRule<T> equalsTo(final boolean value, final String message) {
        final Predicate<T> predicate = t -> Objects.nonNull(t) && Boolean.valueOf(t) == value;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("equalsTo", message)));
        return this;
    }

    public BooleanRule<T> equalsTo(final boolean value) {
        final Predicate<T> predicate = t -> Objects.nonNull(t) && Boolean.valueOf(t) == value;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("equalsTo", null)));
        return this;
    }

    public BooleanRule<T> notEqualsTo(final boolean value, final String message) {
        final Predicate<T> predicate = t -> Objects.nonNull(t) && Boolean.valueOf(t) != value;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notEqualsTo", message)));
        return this;
    }

    public BooleanRule<T> notEqualsTo(final boolean value) {
        final Predicate<T> predicate = t -> Objects.nonNull(t) && Boolean.valueOf(t) != value;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notEqualsTo", null)));
        return this;
    }

    public BooleanRule<T> isNull(final String message) {
        final Predicate<T> predicate = Objects::isNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isNull", message)));
        return this;
    }

    public BooleanRule<T> isNull() {
        final Predicate<T> predicate = Objects::isNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isNull", null)));
        return this;
    }

    public BooleanRule<T> notNull(final String message) {
        final Predicate<T> predicate = Objects::nonNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notNull", message)));
        return this;
    }

    public BooleanRule<T> notNull() {
        final Predicate<T> predicate = Objects::nonNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notNull", null)));
        return this;
    }

    public BooleanRule<T> isTrue(final String message) {
        final Predicate<T> predicate = t -> Objects.nonNull(t) && Boolean.valueOf(t);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isTrue", message)));
        return this;
    }

    public BooleanRule<T> isTrue() {
        final Predicate<T> predicate = t -> Objects.nonNull(t) && Boolean.valueOf(t);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isTrue", null)));
        return this;
    }

    public BooleanRule<T> isFalse(final String message) {
        final Predicate<T> predicate = t -> Objects.nonNull(t) && !Boolean.valueOf(t);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isFalse", message)));
        return this;
    }

    public BooleanRule<T> isFalse() {
        final Predicate<T> predicate = t -> Objects.nonNull(t) && !Boolean.valueOf(t);
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isFalse", null)));
        return this;
    }
}
