package br.com.simplevalidator.validation;

import br.com.simplevalidator.Validator;

public class ValidationCapsule<V> {

    private final Validator<V> validator;
    private final V instance;

    public ValidationCapsule(Validator<V> validator, V instance) {
        this.validator = validator;
        this.instance = instance;
    }

    public Validator<V> getValidator() {
        return validator;
    }

    public V getInstance() {
        return instance;
    }
}
