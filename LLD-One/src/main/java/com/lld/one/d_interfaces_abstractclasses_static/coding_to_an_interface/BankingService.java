package com.lld.one.d_interfaces_abstractclasses_static.coding_to_an_interface;

public interface BankingService {
    // all methods are by default abstract and public.
    public abstract double checkBalance(int accountNumber);
    public abstract void pay(int from, int to, double amount);
}
