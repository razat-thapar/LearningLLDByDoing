package com.lld.three.exceptions;

public class InvalidDifficultyLevelException extends RuntimeException{
    public InvalidDifficultyLevelException(String message) {
        super(message);
    }
}
