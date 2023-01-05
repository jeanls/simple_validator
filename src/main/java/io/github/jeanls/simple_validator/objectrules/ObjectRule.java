package io.github.jeanls.simple_validator.objectrules;

import io.github.jeanls.simple_validator.RulePredicate;
import io.github.jeanls.simple_validator.commonrules.Rule;
import io.github.jeanls.simple_validator.utils.Bundle;

import java.util.Objects;
import java.util.function.Predicate;

public class ObjectRule <F> extends Rule<F> {

    public ObjectRule<F> notNull(final String message) {
        final Predicate<F> predicate = Objects::nonNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notNull", message)));
        return this;
    }

    public ObjectRule<F> notNull() {
        final Predicate<F> predicate = Objects::nonNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notNull", null)));
        return this;
    }
}
