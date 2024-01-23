package com.lld.two.j_observer_pattern.b_fix1_usingPolling;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trigger implements Runnable{
    private BitcoinPriceTracker bitcoinPriceTracker;
    @Override
    public void run() {
        try {
            Thread.sleep(5000); //10sec.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //change price.
        System.out.printf("Price change triggered by %s%n",Thread.currentThread().getName());
        bitcoinPriceTracker.setPrice(324234.23);
    }
}
