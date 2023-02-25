package io.github.jeanls.simplevalidator.exceptions;

import io.github.jeanls.simplevalidator.validation.ValidationResult;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public abstract class ValidationException extends RuntimeException {

    private static final long serialVersionUID = 7209101791730075471L;
    private final transient ValidationResult validationResult;

    protected ValidationException(final ValidationResult validationResult) {
        this.validationResult = validationResult;
    }

    public ValidationResult getErrors() {
        return validationResult;
    }

    public static <T extends ValidationException> ValidationException build(final Class<T> tClass, final ValidationResult validationResult) {
        try {
            final Constructor<? extends ValidationException> constructor = tClass.getConstructor(ValidationResult.class);
            return constructor.newInstance(validationResult);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
