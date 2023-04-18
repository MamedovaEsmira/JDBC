package ru.mamedova.exception;

public class NotFoundEmployeeAtDBException extends RuntimeException {
    public NotFoundEmployeeAtDBException() {
    }

    public NotFoundEmployeeAtDBException(String message) {
        super(message);
    }

    public NotFoundEmployeeAtDBException(String message, Throwable cause) {
        super(message, cause);
    }
}