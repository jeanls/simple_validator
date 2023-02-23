package io.github.jeanls.simplevalidator.utils;

import java.math.BigDecimal;

@FunctionalInterface
public interface NumberWrapper<T> {

    BigDecimal accept(T t);
}
