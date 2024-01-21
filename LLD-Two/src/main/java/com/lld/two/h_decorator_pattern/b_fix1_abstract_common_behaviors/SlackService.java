package com.lld.two.h_decorator_pattern.b_fix1_abstract_common_behaviors;

public class SlackService implements Communicator{

    @Override
    public void send(User user, String message) {
        System.out.printf("Sending a slack notification to %s with message : %s %n",user.getEmail(),message);
    }
}
