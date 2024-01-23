package com.lld.two.j_observer_pattern.a_problem;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static Bitcoin bitcoin;
    private static BitcoinPriceTracker bitcoinPriceTracker;
    public static void main(String[] args) {
        //3rd party API of Bitcoin invoking BitcoinPriceTracker setPrice() method whenever price changes
        //Our App will notify all subscribers about price change of bitcoin object.
        //approach 1: invoke sendEmail() method in setPrice() method so to trigger it if price is changed.
        //initialize the state.
        initialize();
        //create trigger from 3rd party API.
        trigger();

        //PRO:
        //1. it works!.

        //CONS:
        //1. SRP is violated ( setPrice(double price) have mutliple reasons to change. e.g., if email method changes, if setPrice changes)
        //2. OCP is violated ( what if we want to trigger sms alerts alongwith emails in future, setPrice(double price) will be open for modification)

    }
    public static void initialize(){
        //List of emails.
        List<String> emails = List.of("abc@g.com","def@g.com");
        bitcoin = Bitcoin.getInstance();
        bitcoinPriceTracker = new BitcoinPriceTracker();
        bitcoinPriceTracker.setBitcoin(bitcoin);
        bitcoinPriceTracker.setEmails(emails);
    }
    public static void trigger(){
        bitcoinPriceTracker.setPrice(72323.32);
    }
}
