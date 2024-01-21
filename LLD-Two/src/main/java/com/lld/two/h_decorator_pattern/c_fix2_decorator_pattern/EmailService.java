package com.lld.two.h_decorator_pattern.c_fix2_decorator_pattern;

public class EmailService implements Communicator {
    @Override
    public void send(User user, String message){
        System.out.printf("Sending an email to %s with message : %s %n",user.getEmail(),message);
    }
}
