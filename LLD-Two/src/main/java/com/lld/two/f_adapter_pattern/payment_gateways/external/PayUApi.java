package com.lld.two.f_adapter_pattern.payment_gateways.external;
//Step 1: Create external classes (Incompatible Interfaces)
public class PayUApi {
    public void makePayment(int amount){
        System.out.printf("PayU paid %d %n",amount);
    }

    public PayUStatus getStatus(int id){
        //This is just for demonstration purposes.
        if(id%2==0){
            return PayUStatus.SUCCESS; //success.
        }else{
            return PayUStatus.FAILURE; //failure.
        }
    }
}
