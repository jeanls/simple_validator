package io.github.jeanls.simplevalidator.validation;

import io.github.jeanls.simplevalidator.exceptions.ValidationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationResultTest {

    @Test
    void validTest() {
        assertTrue(ValidationResult.valid().isValid());
    }

    @Test
    void invalidTest() {
        assertFalse(ValidationResult.invalid().isValid());
    }

    @Test
    void onErrorThrowTest() {
        ValidationResult validationResult = ValidationResult.invalid();
        assertThrows(BadRequestException.class,  () -> validationResult.onErrorThrow(BadRequestException.class));
    }

    public static class BadRequestException extends ValidationException {

        public BadRequestException(ValidationResult validationResult) {
            super(validationResult);
        }
    }
}