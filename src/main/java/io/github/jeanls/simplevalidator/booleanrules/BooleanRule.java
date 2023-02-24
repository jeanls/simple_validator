package io.github.jeanls.simplevalidator.booleanrules;

import io.github.jeanls.simplevalidator.RulePredicate;
import io.github.jeanls.simplevalidator.commonrules.Rule;
import io.github.jeanls.simplevalidator.utils.Bundle;

import java.util.Objects;
import java.util.function.Predicate;

public class BooleanRule extends Rule<Boolean> {

    public BooleanRule equalsTo(final boolean value, final String message) {
        final Predicate<Boolean> predicate = t -> Objects.nonNull(t) && t == value;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("equalsTo", message)));
        return this;
    }

    public BooleanRule equalsTo(final boolean value) {
        final Predicate<Boolean> predicate = t -> Objects.nonNull(t) && t == value;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("equalsTo", null)));
        return this;
    }

    public BooleanRule notEqualsTo(final boolean value, final String message) {
        final Predicate<Boolean> predicate = t -> Objects.nonNull(t) && t != value;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notEqualsTo", message)));
        return this;
    }

    public BooleanRule notEqualsTo(final boolean value) {
        final Predicate<Boolean> predicate = t -> Objects.nonNull(t) && t != value;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notEqualsTo", null)));
        return this;
    }

    public BooleanRule isNull(final String message) {
        final Predicate<Boolean> predicate = Objects::isNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isNull", message)));
        return this;
    }

    public BooleanRule isNull() {
        final Predicate<Boolean> predicate = Objects::isNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isNull", null)));
        return this;
    }

    public BooleanRule notNull(final String message) {
        final Predicate<Boolean> predicate = Objects::nonNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notNull", message)));
        return this;
    }

    public BooleanRule notNull() {
        final Predicate<Boolean> predicate = Objects::nonNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notNull", null)));
        return this;
    }

    public BooleanRule isTrue(final String message) {
        final Predicate<Boolean> predicate = t -> Objects.nonNull(t) && t;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isTrue", message)));
        return this;
    }

    public BooleanRule isTrue() {
        final Predicate<Boolean> predicate = t -> Objects.nonNull(t) && t;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isTrue", null)));
        return this;
    }

    public BooleanRule isFalse(final String message) {
        final Predicate<Boolean> predicate = t -> Objects.nonNull(t) && !t;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isFalse", message)));
        return this;
    }

    public BooleanRule isFalse() {
        final Predicate<Boolean> predicate = t -> Objects.nonNull(t) && !t;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("isFalse", null)));
        return this;
    }
}
