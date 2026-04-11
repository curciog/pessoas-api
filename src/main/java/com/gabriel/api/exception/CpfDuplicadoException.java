package com.gabriel.api.exception;

public class CpfDuplicadoException extends RuntimeException { // ajuste pro code review

    public CpfDuplicadoException(String message) {
        super(message);
    }
}