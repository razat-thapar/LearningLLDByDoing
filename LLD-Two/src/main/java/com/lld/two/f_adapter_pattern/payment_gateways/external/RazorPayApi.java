package com.lld.two.f_adapter_pattern.payment_gateways.external;
//Step 1: Create external classes (Incompatible Interfaces)
public class RazorPayApi {
    public void createPayment(String name , int amount){
        System.out.printf("Razor pay paid %d to %s %n",amount,name);
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

