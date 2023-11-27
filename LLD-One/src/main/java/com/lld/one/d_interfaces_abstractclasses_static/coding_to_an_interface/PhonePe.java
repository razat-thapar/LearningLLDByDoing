package com.lld.one.d_interfaces_abstractclasses_static.coding_to_an_interface;

import java.util.HashMap;
import java.util.Map;

public class PhonePe implements changablePin{

    private static Map<String,Integer> map = new HashMap<>();

    private static Map<String,Integer> pinMap = new HashMap<>();

    private BankingService bankingService;
    public PhonePe(BankingService bankingService){
        this.bankingService = bankingService;
    }

    public void addUpi(String upi, int accountNumber, int upiPin){
        map.put(upi,accountNumber);
        pinMap.put(upi,upiPin);
        System.out.printf("UPI %s added successfully! %n",upi);
    }

    public double checkBalance(int account){
        return bankingService.checkBalance(account);
    }

    public void transferMoney(String upi , int to, double amount , int upiPin){
        // we need to get from primary account number linked to UPI.
        if(upiPin == pinMap.get(upi)){
            int from = map.get(upi);
            bankingService.pay(from,to,amount);
        }


    }

    @Override
    public void changePin(String upi,int newPin) {
        // we need to change the mapping of UPI PIN.
        if(pinMap.containsKey(upi)){
            pinMap.put(upi,newPin);
        }
    }
}
