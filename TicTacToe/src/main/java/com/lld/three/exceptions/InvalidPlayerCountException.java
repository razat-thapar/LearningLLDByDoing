package com.lld.three.exceptions;

public class InvalidPlayerCountException extends Exception{
    public InvalidPlayerCountException() {
        super();
    }

    public InvalidPlayerCountException(String message) {
        super(message);
    }
}
