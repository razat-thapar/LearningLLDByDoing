package com.lld.two.j_observer_pattern.b_fix1_usingPolling;

public class Polling implements Runnable{
    private Bitcoin bitcoin;
    private BitcoinPriceTracker bitcoinPriceTracker;
    private double oldPrice;
    public Polling(Bitcoin bitcoin, BitcoinPriceTracker bitcoinPriceTracker){
        this.bitcoin = bitcoin;
        this.bitcoinPriceTracker = bitcoinPriceTracker;
        this.oldPrice = 0.0;
    }
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(100); //polling every 100ms.
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(oldPrice != bitcoin.getPrice()){
                oldPrice = bitcoin.getPrice();
                System.out.printf("SendEmail... %s%n",Thread.currentThread().getName());
                bitcoinPriceTracker.sendEmail();
                break;
            }else{
                System.out.printf("Polling... %s%n",Thread.currentThread().getName());
            }
        }
    }
}
