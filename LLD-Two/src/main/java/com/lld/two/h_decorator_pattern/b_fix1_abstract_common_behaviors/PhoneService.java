package com.lld.two.h_decorator_pattern.b_fix1_abstract_common_behaviors;

public class PhoneService implements Communicator{
    @Override
    public void send(User user, String message) {
        System.out.printf("Sending a phone notification to %s with message : %s %n",user.getPhone(),message);
    }
}
