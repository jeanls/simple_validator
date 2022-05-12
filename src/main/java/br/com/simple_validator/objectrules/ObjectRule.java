package br.com.simple_validator.objectrules;

import br.com.simple_validator.RulePredicate;
import br.com.simple_validator.commonrules.Rule;
import br.com.simple_validator.utils.Bundle;

import java.util.Objects;
import java.util.function.Predicate;

public class ObjectRule <F> extends Rule<F> {

    public ObjectRule<F> notNull(final String... message) {
        final Predicate<F> predicate = Objects::nonNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notNull", message)));
        return this;
    }
}
