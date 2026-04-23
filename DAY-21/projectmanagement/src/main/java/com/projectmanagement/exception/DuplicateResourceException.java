package com.projectmanagement.exception;

public class DuplicateResourceException extends RuntimeException {

    public DuplicateResourceException(String message) {
        super(message);
    }

    public DuplicateResourceException(String resourceName, String fieldName, String fieldValue) {
        super(resourceName + " already exists with " + fieldName + ": " + fieldValue);
    }
}