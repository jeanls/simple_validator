package io.github.jeanls.simple_validator.validator;

import io.github.jeanls.simple_validator.RulePredicate;
import io.github.jeanls.simple_validator.customrule.CustomRule;

public class CustomRuleEx extends CustomRule<String, CustomRuleEx> {

    @Override
    public CustomRuleEx validate(Object... param) {
        this.addPredicate(new RulePredicate<>(s -> s.equals("Jean Leal Silva"), "O nome deve ser igual a Jean Leal Silva."));
        return this;
    }
}
