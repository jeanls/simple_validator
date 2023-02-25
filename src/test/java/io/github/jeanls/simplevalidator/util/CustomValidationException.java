package io.github.jeanls.simplevalidator.util;

import io.github.jeanls.simplevalidator.exceptions.ValidationException;
import io.github.jeanls.simplevalidator.validation.ValidationResult;

public class CustomValidationException extends ValidationException {

    public CustomValidationException(ValidationResult validationResult) {
        super(validationResult);
    }
}
