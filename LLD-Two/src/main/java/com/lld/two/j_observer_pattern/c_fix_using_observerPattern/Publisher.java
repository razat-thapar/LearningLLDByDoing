package com.lld.two.j_observer_pattern.c_fix_using_observerPattern;

//Step 1: Create Subject interface , or Object of interest interface i.e., BTC price
public interface Publisher {
    void addSubscriber(Subscriber subscriber);
    void removeSubscriber(Subscriber subscriber);
    void notifyAllSubscribers();
}
