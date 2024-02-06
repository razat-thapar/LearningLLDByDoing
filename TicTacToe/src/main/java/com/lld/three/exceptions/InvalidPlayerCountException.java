package com.lld.three.exceptions;

public class InvalidPlayerCountException extends RuntimeException{
    public InvalidPlayerCountException() {
        super();
    }

    public InvalidPlayerCountException(String message) {
        super(message);
    }
}
