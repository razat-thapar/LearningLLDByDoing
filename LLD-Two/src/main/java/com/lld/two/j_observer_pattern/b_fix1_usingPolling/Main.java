package com.lld.two.j_observer_pattern.b_fix1_usingPolling;

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
//        trigger();

        //PRO:
        //1. it works!.

        //CONS:
        //1. SRP is violated ( setPrice(double price) have mutliple reasons to change. e.g., if email method changes, if setPrice changes)
        //2. OCP is violated ( what if we want to trigger sms alerts alongwith emails in future, setPrice(double price) will be open for modification)

        //FIX 1 : POLLING
        // continously look out for change in price of bitcoin and then send the notification if any changes.
        // we can have 3 threads ( main , pollingThread , triggerThread)
        //pollingThread task is to keep checking for changes in bitcoin object.
        //triggerThread task is to setPrice() after some delay.
        //main thread , start the app.
        Thread t1 = new Thread(new Polling(bitcoin,bitcoinPriceTracker));
        Thread t2 = new Thread(new Trigger(bitcoinPriceTracker));
        //start.
        t1.start();
        t2.start();
        //main wait for both threads to complete action.
        try {
            t1.join(10);
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // PROS:
        // 1. SRP is respected.
        // CONS:
        // 1. OCP is violated
        //  (
        //  a. what if we add a new SendSms() method , SendTweet() method , Polling.run() method will be open for modification).
        //  b. BitcoinPriceTracker class will also be open for modification in above case.
        //  )
        // 2. Wastage of CPU cycles / CPU overhead.
    }
    public static void initialize(){
        //List of emails.
        List<String> emails = List.of("abc@g.com","def@g.com");
        bitcoin = Bitcoin.getInstance();
        bitcoinPriceTracker = new BitcoinPriceTracker();
        bitcoinPriceTracker.setBitcoin(bitcoin);
        bitcoinPriceTracker.setEmails(emails);
    }
//    public static void trigger(){
//        bitcoinPriceTracker.setPrice(72323.32);
//    }
}
