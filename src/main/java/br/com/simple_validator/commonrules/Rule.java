package br.com.simple_validator.commonrules;

import br.com.simple_validator.RulePredicate;

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
