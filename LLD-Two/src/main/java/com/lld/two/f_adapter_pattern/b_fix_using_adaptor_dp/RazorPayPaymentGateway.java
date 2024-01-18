package com.lld.two.f_adapter_pattern.b_fix_using_adaptor_dp;

import com.lld.two.f_adapter_pattern.payment_gateways.external.RazorPayApi;
//Step 3: Concrete Adapter classes.
public class RazorPayPaymentGateway implements PaymentGateway{
    private RazorPayApi api;
    public RazorPayPaymentGateway(RazorPayApi api){
        this.api = api;
    }
    //step 4: Transform/adapt external apis to Adapter interface.
    @Override
    public void makePayment(Long id, String name, double amount) {
        api.createPayment(name,(int)amount);
    }

    @Override
    public PaymentStatus verifyStatus(Long id) {
        long identifier = id;
        int status = api.checkStatus((int)identifier);
        return toPaymentStatus(status);
    }
    //mapper method .
    private static PaymentStatus toPaymentStatus(int status){
        switch(status){
            case 0 : return PaymentStatus.ERROR;
            case 1 : return PaymentStatus.OK;
        }
        throw new RuntimeException("Invalid status");
    }
}
