package br.com.fiap.exception;

public class ValidationException extends Exception {
    public ValidationException() {
        super();
    }

    public ValidationException(String message) {
        super(message);
    }
}
