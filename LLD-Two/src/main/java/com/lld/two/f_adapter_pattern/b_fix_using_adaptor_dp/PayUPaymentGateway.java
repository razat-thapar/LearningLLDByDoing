package com.lld.two.f_adapter_pattern.b_fix_using_adaptor_dp;

import com.lld.two.f_adapter_pattern.payment_gateways.external.PayUApi;
import com.lld.two.f_adapter_pattern.payment_gateways.external.PayUStatus;

//Step 3: Concrete Adapter classes.
public class PayUPaymentGateway implements PaymentGateway{
    private PayUApi api;
    public PayUPaymentGateway(PayUApi api){
        this.api = api;
    }
    //Step 4: transform / adapt to Adapter interface.
    @Override
    public void makePayment(Long id, String name, double amount) {
        api.makePayment((int)amount);
    }

    @Override
    public PaymentStatus verifyStatus(Long id) {
        long identifier = id;
        PayUStatus status = api.getStatus((int)identifier);
        return toPaymentStatus(status);
    }
    //mapper method.
    private static PaymentStatus toPaymentStatus(PayUStatus status){
        switch (status){
            case SUCCESS -> {return PaymentStatus.OK;}
            case FAILURE -> {return PaymentStatus.ERROR;}
        }
        throw new RuntimeException("INvalid status");
    }
}
