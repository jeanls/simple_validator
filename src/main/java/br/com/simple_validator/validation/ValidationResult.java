package br.com.simple_validator.validation;

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
}
