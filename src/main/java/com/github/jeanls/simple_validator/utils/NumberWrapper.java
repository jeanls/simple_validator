package com.github.jeanls.simple_validator.utils;

import java.math.BigDecimal;

@FunctionalInterface
public interface NumberWrapper<T> {

    BigDecimal accept(T t);
}
