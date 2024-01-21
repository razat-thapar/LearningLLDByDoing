package com.lld.two.h_decorator_pattern.c_fix2_decorator_pattern;

public abstract class CommunicatorDecorator implements Communicator{
    protected Communicator communicator;
    public CommunicatorDecorator(Communicator communicator){
        this.communicator = communicator;
    }
}
