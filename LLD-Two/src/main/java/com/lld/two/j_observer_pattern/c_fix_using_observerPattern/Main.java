package com.lld.two.j_observer_pattern.c_fix_using_observerPattern;

import java.util.List;

public class Main {
    private static BitcoinPriceTracker bitcoinPriceTracker;
    public static void main(String[] args) {
        //3rd party API of Bitcoin invoking BitcoinPriceTracker setPrice() method whenever price changes
        //Our App will notify all subscribers about price change of bitcoin object.
        //approach 1: invoke sendEmail() method in setPrice() method so to trigger it if price is changed.
        //initialize the state.
        //initialize();
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
//        Thread t1 = new Thread(new Polling(bitcoin,bitcoinPriceTracker));
//        Thread t2 = new Thread(new Trigger(bitcoinPriceTracker));
//        //start.
//        t1.start();
//        t2.start();
//        //main wait for both threads to complete action.
//        try {
//            t1.join(10);
//            t2.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        // PROS:
        // 1. SRP is respected.
        // CONS:
        // 1. OCP is violated
        //  (
        //  a. what if we add a new SendSms() method , SendTweet() method , Polling.run() method will be open for modification).
        //  b. BitcoinPriceTracker class will also be open for modification in above case.
        //  )
        // 2. Wastage of CPU cycles / CPU overhead.

        //BEST Fix:  Publisher / Subscriber Pattern   or Observer Pattern.
        //Step 1: Create a Publisher interface or Subject interface (Object of interest)
        ///        having addSubscriber(Subscriber subscriber) , removeSubscriber() , notifyAllSubscribers()
        //Step 2: Create a Subscriber interface ( observers )
        ///        having void takeAction() method.
        //Step 3: Create an abstract class named SetBasedPublisher that implements publisher interface using Set<Subscriber>
        //        why abstract  ?  every publisher will have different set of subscribers.
        //Step 4: Choose or create the class that is our object of interest for which subscribers needs to be notified
        // and extend SetBasedPublisher class , which will invoke notifyAllSubscribers() method.
        //Step 5: Concrete Subscriber classes.
        //Step 6: Client code
        //       1. Create objects of subscribers.
        //       2. Create object of step4 i.e., publisher concrete classes and add subscribers.
        //       3. trigger notifyAllSubscribers() method.
        initialize();
        trigger();
    }
    public static void initialize(){
        //List of emails.
        List<String> mailingList = List.of("abc@g.com","def@g.com");
        String message = "Price change Alert!";
        //create instance of subscribers
        EmailSender emailSender = new EmailSender(mailingList,message);
        TweetSender tweetSender = new TweetSender(message);
        //create instance of publisher .
        bitcoinPriceTracker = new BitcoinPriceTracker(Bitcoin.getInstance());
        //add subscribers to publisher
        bitcoinPriceTracker.addSubscriber(emailSender);
        bitcoinPriceTracker.addSubscriber(tweetSender);
    }
    public static void trigger(){
        bitcoinPriceTracker.setPrice(72323.32);
    }
}
