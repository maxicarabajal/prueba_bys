package com.prueba.bys.infrastructure.exceptions;

public class LogicalDeleteException extends RuntimeException{
    public LogicalDeleteException(String message) {
        super(message);
    }
}
