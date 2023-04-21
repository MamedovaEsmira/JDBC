package ru.mamedova.exception;

public class NotFoundCityAtDBException extends RuntimeException{
    public NotFoundCityAtDBException() {
    }

    public NotFoundCityAtDBException(String message) {
        super(message);
    }

    public NotFoundCityAtDBException(String message, Throwable cause) {
        super(message, cause);
    }
}
