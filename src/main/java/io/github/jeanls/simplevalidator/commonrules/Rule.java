package io.github.jeanls.simplevalidator.commonrules;

import io.github.jeanls.simplevalidator.RulePredicate;

import java.util.LinkedList;
import java.util.List;

public abstract class Rule<F> {

    private final LinkedList<RulePredicate<F>> rules = new LinkedList<>();

    protected void addPredicate(final RulePredicate<F> predicate) {
        this.rules.add(predicate);
    }

    public List<RulePredicate<F>> getRules() {
        return rules;
    }
}
