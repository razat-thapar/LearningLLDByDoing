package com.lld.two.h_decorator_pattern.a_problem;

public class EmailService {
    public void sendEmail(User user, String message){
        System.out.printf("Sending an email to %s with message : %s %n",user.getEmail(),message);
    }
}
