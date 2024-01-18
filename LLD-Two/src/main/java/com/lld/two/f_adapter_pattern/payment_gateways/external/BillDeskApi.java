package com.lld.two.f_adapter_pattern.payment_gateways.external;

public class BillDeskApi {
    public void createPayment(String name , String email, AccountType type, int amount){
        System.out.printf("BillDesk paid %d to %s from %s : receipient email : %s %n",amount,name,type,email);
    }

    public int checkStatus(int id){
        //This is just for demonstration purposes.
        if(id%2==0){
            return 1; //success.
        }else{
            return 0; //failure.
        }
    }
}
