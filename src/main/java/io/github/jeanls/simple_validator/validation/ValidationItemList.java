package io.github.jeanls.simple_validator.validation;

import io.github.jeanls.simple_validator.Validator;

import java.util.List;
import java.util.function.Function;

public class ValidationItemList<D, V extends List<I>, I> {

    private final Validator<I> validator;
    private final Function<D, V> item;

    public ValidationItemList(Validator<I> validator, Function<D, V> item) {
        this.validator = validator;
        this.item = item;
    }

    public Validator<I> getValidator() {
        return validator;
    }

    public Function<D, V> getItem() {
        return item;
    }
}
