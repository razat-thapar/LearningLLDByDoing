package com.lld.two.f_adapter_pattern.c_assignment_multipleRequestParams;

import com.lld.two.f_adapter_pattern.payment_gateways.external.AccountType;

// step 2: Create adapter interface
public interface PaymentGateway {
    //make payment.
    void makePayment(PaymentDTO paymentDTO);

    //check status.
    PaymentStatus verifyStatus(Long id);
}
