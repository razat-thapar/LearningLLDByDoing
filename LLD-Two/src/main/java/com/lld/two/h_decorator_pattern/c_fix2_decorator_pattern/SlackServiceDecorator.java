package com.lld.two.h_decorator_pattern.c_fix2_decorator_pattern;

public class SlackServiceDecorator extends CommunicatorDecorator {
    public SlackServiceDecorator(Communicator communicator) {
        super(communicator);
    }

    @Override
    public void send(User user, String message) {
        communicator.send(user,message);
        System.out.printf("Sending a slack notification to %s with message : %s %n",user.getEmail(),message);
    }
}
