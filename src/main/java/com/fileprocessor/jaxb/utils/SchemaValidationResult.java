package com.fileprocessor.jaxb.utils;

public class SchemaValidationResult {

    private final boolean valid;
    private final String message;

    public SchemaValidationResult(final boolean valid, final String message) {
        this.valid = valid;
        this.message = message;
    }

    public boolean isValid() {
        return valid;
    }

    public String getMessage() {
        return message;
    }

}
