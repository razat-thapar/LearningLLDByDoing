package com.lld.two.f_adapter_pattern.b_fix_using_adaptor_dp;
// step 2: Create adapter interface
public interface PaymentGateway {
    //make payment.
    void makePayment(Long id , String name,double amount);
    //check status.
    PaymentStatus verifyStatus(Long id);
}
