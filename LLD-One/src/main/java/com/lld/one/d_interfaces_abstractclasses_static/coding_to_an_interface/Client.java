package com.lld.one.d_interfaces_abstractclasses_static.coding_to_an_interface;

public class Client {
    public static void main(String[] args) {
        //Scenario 1: Using subtype polymorphism.
        BankingService icici = new ICICIBank();
        BankingService hdfc = new HDFCBank();

        PhonePe app = new PhonePe(hdfc);

        app.addUpi("7973712722@okicici", 288209348, 2307);
        System.out.println(app.checkBalance(288209348));
        app.transferMoney("7973712722@okicici",288209343,510.5, 2307);
    }
}
