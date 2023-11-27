package com.lld.one.d_interfaces_abstractclasses_static.coding_to_an_interface;


public class ICICIBank implements BankingService{

    @Override
    public double checkBalance(int accountNumber) {
        if(accountNumber == 0 ){
            return -1;
        }
        return 1000;
    }

    @Override
    public void pay(int from, int to, double amount) {
        System.out.printf("ICICI BANK Paid %f amount to %d from %d %n",amount,to,from);
    }
}
