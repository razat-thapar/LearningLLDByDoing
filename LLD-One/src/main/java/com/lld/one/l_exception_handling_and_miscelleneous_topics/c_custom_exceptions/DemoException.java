package com.lld.one.l_exception_handling_and_miscelleneous_topics.c_custom_exceptions;

public class DemoException extends Exception{
    public DemoException(){
        super();
    }
    public DemoException(String message) {
        super(message);
    }
}
