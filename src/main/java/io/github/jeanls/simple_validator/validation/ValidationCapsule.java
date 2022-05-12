package io.github.jeanls.simple_validator.validation;

import io.github.jeanls.simple_validator.Validator;

import java.util.function.Function;

public class ValidationCapsule<K, V> {

    private final Validator<V> validator;
    private final Function<K, V> instance;

    public ValidationCapsule(Validator<V> validator, Function<K, V> instance) {
        this.validator = validator;
        this.instance = instance;
    }

    public Validator<V> getValidator() {
        return validator;
    }

    public Function<K, V> getInstance() {
        return instance;
    }
}
