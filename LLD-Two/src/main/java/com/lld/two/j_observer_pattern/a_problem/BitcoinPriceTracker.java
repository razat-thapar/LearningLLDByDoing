package com.lld.two.j_observer_pattern.a_problem;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BitcoinPriceTracker {
    private Bitcoin bitcoin;
    private List<String> emails;
    public void setPrice(double price){
        bitcoin.setPrice(price);
        sendEmail();
    }
    public void setEmails(List<String> emails){
        this.emails = emails;
    }
    private void sendEmail(){
        System.out.printf("Bitcoin Price changed : %f Sending email to all email subscribers: %s",bitcoin.getPrice(),emails);
    }


}
