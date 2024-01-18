package com.lld.two.f_adapter_pattern.c_assignment_multipleRequestParams;

import com.lld.two.f_adapter_pattern.payment_gateways.external.AccountType;
import com.lld.two.f_adapter_pattern.payment_gateways.external.RazorPayApi;
//Step 3: Concrete Adapter classes.
public class RazorPayPaymentGateway implements PaymentGateway {
    private RazorPayApi api;
    public RazorPayPaymentGateway(RazorPayApi api){
        this.api = api;
    }
    //step 4: Transform/adapt external apis to Adapter interface.
    @Override
    public void makePayment(PaymentDTO paymentDTO) {
        api.createPayment(paymentDTO.getName(), (int)paymentDTO.getAmount());
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
