package com.lld.two.j_observer_pattern.c_fix_using_observerPattern;

import java.util.Set;
import java.util.HashSet;

public abstract class SetBasedPublisher implements Publisher{
    private Set<Subscriber> subscriberSet ;

    public SetBasedPublisher(){
        this.subscriberSet = new HashSet<>();
    }
    @Override
    public void addSubscriber(Subscriber subscriber) {
        this.subscriberSet.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        this.subscriberSet.remove(subscriber);
    }

    @Override
    public void notifyAllSubscribers() {
        subscriberSet.forEach(Subscriber::sendNotification);
    }
}
