package br.com.simplevalidator.commonrules;

import br.com.simplevalidator.RulePredicate;

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
