package com.prueba.bys.domain.exceptions;

public class DuplicatedNameException extends RuntimeException {
    public DuplicatedNameException(String message) {
        super(message);
    }
}
