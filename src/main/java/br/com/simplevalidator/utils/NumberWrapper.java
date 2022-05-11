package br.com.simplevalidator.utils;

import java.math.BigDecimal;

@FunctionalInterface
public interface NumberWrapper<T> {

    BigDecimal accept(T t);
}
