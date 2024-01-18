package com.lld.two.f_adapter_pattern.d_assignment_factoryMethodPattern;

import com.lld.two.f_adapter_pattern.c_assignment_multipleRequestParams.BillDeskPaymentGateway;
import com.lld.two.f_adapter_pattern.payment_gateways.external.AccountType;
import com.lld.two.f_adapter_pattern.payment_gateways.external.BillDeskApi;

public class Client {
    private static PaymentGatewayFactory paymentGatewayFactory = new PayUPaymentGatewayFactory();
    public static void main(String[] args) {
        //Approach 2: Adaptor Design Pattern.
        //steps:
        //1. create external incompatible classes  (or import SDK of external api's )
        //2. create an Adapter interface (common behaviors that we need from external APIs)
        //3. create Concrete Adapter classes / subclasses.
        //4. Transform the request from adapter interface to original class(SDK) in adapter subclasses.

//        paymentGateway.makePayment(23L,"Razat",234);
//        System.out.println(paymentGateway.verifyStatus(23L));

        //PROS:
        //1. No OCP violation. (we can add AmazonPay payment gateway without modifying our existing code)
        //2. No SRP violation.
        //3. client is now coding to an interface.
        //4. can switch easily between different gateways as per status of our transaction.

        //CONS:
        //NONE

        //Assignments:
        //1. What if we add a new payment gateway that needs more parameters to make payment?
        //FIX:  Create a DTO class that will hold all the parameters and we can use builder pattern here to initialize it.
//        PaymentDTO paymentDTO = PaymentDTO
//                .builder()
//                .email("aggarwal@gmail.com")
//                .id(23)
//                .accountType(AccountType.SAVING)
//                .name("Razat")
//                .amount(399)
//                .build();
//        paymentGateway.makePayment(paymentDTO);
//        System.out.println(paymentGateway.verifyStatus(paymentDTO.getId()));
        
        //2. How can we avoid tight coupling with adapter subclasses for object creation ?
        //FIX: Use Factory Method Pattern.
        //Step 1: create a product interface
        //Step 2: create product subclasses
        //Step 3: create factory interface.
        //step 4: create factory subclasses.
        //Step 5: client code will use factory to create objects.
        PaymentGateway paymentGateway = paymentGatewayFactory.createPaymentGateway();
        PaymentDTO paymentDTO = PaymentDTO
                .builder()
                .email("aggarwal@gmail.com")
                .id(23)
                .accountType(AccountType.SAVING)
                .name("Razat")
                .amount(399)
                .build();
        paymentGateway.makePayment(paymentDTO);
        System.out.println(paymentGateway.verifyStatus(paymentDTO.getId()));
    }
}
