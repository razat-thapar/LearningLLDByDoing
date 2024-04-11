package com.razat.ems.exceptions;

public class InvalidEmployeeException extends RuntimeException {
    public InvalidEmployeeException(String s) {
        super(s);
    }
}
