package com.lld.two.j_observer_pattern.c_fix_using_observerPattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TweetSender implements Subscriber{
    private String message;
    @Override
    public void sendNotification() {
        System.out.printf("Sending Tweet : %s",message);
    }
}
