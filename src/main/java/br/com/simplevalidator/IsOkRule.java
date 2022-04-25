package br.com.simplevalidator;

import br.com.simplevalidator.customrule.CustomRule;

public class IsOkRule extends CustomRule<String, IsOkRule> {

    @Override
    public IsOkRule validate(Object param) {
        this.addPredicate(new RulePredicate<>(s1 -> s1.equals("PKY2J17"), "Não é igual a placa de jean"));
        return this;
    }

    @Override
    public IsOkRule validate() {
        this.addPredicate(new RulePredicate<>(s1 -> s1.equals("PKY2J15"), "Não é igual a placa de jean"));
        return this;
    }
}
