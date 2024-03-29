package io.github.jeanls.simplevalidator.validation;

public class ValidationError {

    private String fieldName;
    private final Object attemptedValue;
    private String message;

    public ValidationError(String fieldName, Object attemptedValue, String message) {
        this.fieldName = fieldName;
        this.attemptedValue = attemptedValue;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getAttemptedValue() {
        return attemptedValue;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}
