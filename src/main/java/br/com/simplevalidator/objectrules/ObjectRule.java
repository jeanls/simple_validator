package br.com.simplevalidator.objectrules;

import br.com.simplevalidator.RulePredicate;
import br.com.simplevalidator.commonrules.Rule;
import br.com.simplevalidator.utils.Bundle;

import java.util.Objects;
import java.util.function.Predicate;

public class ObjectRule <F> extends Rule<F> {

    public ObjectRule<F> notNull(final String... message) {
        final Predicate<F> predicate = Objects::nonNull;
        this.addPredicate(new RulePredicate<>(predicate, Bundle.getInstance().get("notNull", message)));
        return this;
    }
}
