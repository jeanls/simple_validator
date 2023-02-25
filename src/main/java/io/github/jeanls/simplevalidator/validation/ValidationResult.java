package io.github.jeanls.simplevalidator.validation;

import io.github.jeanls.simplevalidator.exceptions.ValidationException;

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
}
