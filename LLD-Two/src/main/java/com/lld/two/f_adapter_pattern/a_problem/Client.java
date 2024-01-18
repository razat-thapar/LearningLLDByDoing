package com.lld.two.f_adapter_pattern.a_problem;

import com.lld.two.f_adapter_pattern.payment_gateways.external.PayUApi;
import com.lld.two.f_adapter_pattern.payment_gateways.external.PayUStatus;
import com.lld.two.f_adapter_pattern.payment_gateways.external.RazorPayApi;

public class Client {
    public static void main(String[] args) {
        //USE CASE (PROBLEM STATEMENT) :  We are flipkart and have to connect with different payment gateways/providers so to enable transactions between flipkart customers with their banks.
        //now , we need to connect to first PayUAPI  and then RazorPay API if failure in PayU.
        //PayUAPI maybe using different methods and request and response types compared with RazorPay API.
        //hence, both are incompatible interfaces.
        //how we will achieve it?

        // B.F :  If else .
        //In our flipkart payment service , we will use if else logic to enable customers make transactions with their banks.
        PaymentGatewayType type = PaymentGatewayType.PAYU;
        if(type == PaymentGatewayType.PAYU){
            PayUApi api = new PayUApi();
            api.makePayment(234);
            PayUStatus status = api.getStatus(23);
            System.out.println(status);
        }else if(type == PaymentGatewayType.RAZORPAY){
            RazorPayApi api = new RazorPayApi();
            api.createPayment("Razat",234);
            int status = api.checkStatus(23);
            System.out.println(status);
        }

        //PROS:
        //1. it works but still a poor design.
        //CONS:
        //1. if we add a new payment gateway , then we need to modify existing code . OCP violation.
        //2. we have multiple reasons to change this code entity. SRP violation.
        //3. direct dependency between flipkart payment service and API's SDK classes. Violation of dependency inversion.
    }
}
