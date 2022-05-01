package br.com.simplevalidator.customrule;

import br.com.simplevalidator.commonrules.Rule;

public abstract class CustomRule<F, R extends CustomRule<F, R>> extends Rule<F> {

    public abstract R validate(Object... param);

}
