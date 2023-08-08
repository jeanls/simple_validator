package io.github.jeanls.simplevalidator.validation;

import io.github.jeanls.simplevalidator.exceptions.ValidationException;

import java.util.Collections;
import java.util.List;

public class ValidationResult {

    private final boolean valid;
    private final List<ValidationError> errors;

    public boolean isValid() {
        return valid;
    }

    public List<ValidationError> getErrors() {
        return errors;
    }

    public ValidationResult(boolean valid, List<ValidationError> errors) {
        this.valid = valid;
        this.errors = errors;
    }

    public <T extends ValidationException> void onErrorThrow(final Class<T> tClass) {
        if (!valid) {
            throw ValidationException.build(tClass, this);
        }
    }

    public static ValidationResult valid() {
        return new ValidationResult(true, Collections.emptyList());
    }

    public static ValidationResult invalid() {
        return new ValidationResult(false, Collections.emptyList());
    }
}
