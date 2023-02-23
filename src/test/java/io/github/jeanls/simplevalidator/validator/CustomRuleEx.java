package io.github.jeanls.simplevalidator.validator;

import io.github.jeanls.simplevalidator.RulePredicate;
import io.github.jeanls.simplevalidator.commonrules.Rule;

public class CustomRuleEx extends Rule<String> {

    public CustomRuleEx validate() {
        this.addPredicate(new RulePredicate<>(s -> s.equals("Jean Leal Silva"), "O nome deve ser igual a Jean Leal Silva."));
        return this;
    }
}
