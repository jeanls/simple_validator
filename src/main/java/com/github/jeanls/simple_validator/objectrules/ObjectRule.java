package com.github.jeanls.simple_validator.objectrules;

import com.github.jeanls.simple_validator.RulePredicate;
import com.github.jeanls.simple_validator.commonrules.Rule;
import com.github.jeanls.simple_validator.utils.Bundle;

import java.util.Objects;
import java.util.function.Predicate;

public class ObjectRule <F> extends Rule<F> {

    public ObjectRule<F> notNull(final String... message) {
        final Predicate<F> predicate = Objects::nonNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notNull", message)));
        return this;
    }
}
