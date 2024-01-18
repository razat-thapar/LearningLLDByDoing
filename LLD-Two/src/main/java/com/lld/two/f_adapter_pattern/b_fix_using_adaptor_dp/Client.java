package com.lld.two.f_adapter_pattern.b_fix_using_adaptor_dp;

import com.lld.two.f_adapter_pattern.payment_gateways.external.RazorPayApi;

public class Client {
    private static PaymentGateway paymentGateway = new RazorPayPaymentGateway(new RazorPayApi());
    public static void main(String[] args) {
        //Approach 2: Adaptor Design Pattern.
        //steps:
        //1. create external incompatible classes  (or import SDK of external api's )
        //2. create an Adapter interface (common behaviors that we need from external APIs)
        //3. create Concrete Adapter classes / subclasses.
        //4. Adapt / Transform to Adapter interface.

        paymentGateway.makePayment(23L,"Razat",234);
        System.out.println(paymentGateway.verifyStatus(23L));

        //PROS:
        //1. No OCP violation. (we can add AmazonPay payment gateway without modifying our existing code)
        //2. No SRP violation.
        //3. client is now coding to an interface.
        //4. can switch easily between different gateways as per status of our transaction.

        //CONS:
        //NONE

        //Assignments:
        //1. What if we add a new payment gateway that needs more parameters to make payment?
        //2. How we can remove client code dependency with subclasses ?

    }
}
