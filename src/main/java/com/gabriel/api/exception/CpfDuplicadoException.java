package com.gabriel.api.exception;

public class CpfDuplicadoException extends RuntimeException {

    public CpfDuplicadoException(String message) {
        super(message);
    }
}