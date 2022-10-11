package io.github.jeanls.simple_validator.validator;

import io.github.jeanls.simple_validator.RulePredicate;
import io.github.jeanls.simple_validator.commonrules.Rule;

public class CustomRuleEx extends Rule<String> {

    public CustomRuleEx validate() {
        this.addPredicate(new RulePredicate<>(s -> s.equals("Jean Leal Silva"), "O nome deve ser igual a Jean Leal Silva."));
        return this;
    }
}
