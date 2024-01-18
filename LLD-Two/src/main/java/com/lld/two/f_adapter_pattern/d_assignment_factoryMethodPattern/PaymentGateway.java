package com.lld.two.f_adapter_pattern.d_assignment_factoryMethodPattern;

// step 2: Create adapter interface
public interface PaymentGateway {
    //make payment.
    void makePayment(PaymentDTO paymentDTO);

    //check status.
    PaymentStatus verifyStatus(Long id);
}
