package br.com.simplevalidator.validator;

import br.com.simplevalidator.RulePredicate;
import br.com.simplevalidator.customrule.CustomRule;

public class CustomRuleEx extends CustomRule<String, CustomRuleEx> {

    @Override
    public CustomRuleEx validate(Object... param) {
        this.addPredicate(new RulePredicate<>(s -> s.equals("Jean Leal Silva"), "O nome deve ser igual a Jean Leal Silva."));
        return this;
    }
}
