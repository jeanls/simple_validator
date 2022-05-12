package com.github.jeanls.simple_validator.customrule;

import com.github.jeanls.simple_validator.commonrules.Rule;

public abstract class CustomRule<F, R extends CustomRule<F, R>> extends Rule<F> {

    public abstract R validate(Object... param);

}
