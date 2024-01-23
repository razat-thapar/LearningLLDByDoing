package com.lld.two.j_observer_pattern.c_fix_using_observerPattern;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BitcoinPriceTracker extends SetBasedPublisher {
    private Bitcoin bitcoin;

    public BitcoinPriceTracker(Bitcoin bitcoin){
        this.bitcoin = bitcoin;
    }
    public void setPrice(double price){
        bitcoin.setPrice(price);
        notifyAllSubscribers();
    }
}
