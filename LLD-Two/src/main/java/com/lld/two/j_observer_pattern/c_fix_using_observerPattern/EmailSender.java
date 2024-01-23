package com.lld.two.j_observer_pattern.c_fix_using_observerPattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class EmailSender implements Subscriber{
    private List<String> mailingList;
    private String message;
    @Override
    public void sendNotification() {
        System.out.printf("%s%n","Sending Email");
        mailingList.forEach((String email) -> {
            System.out.printf(" to: %s message:%s %n",email,message);
        });
    }
}

