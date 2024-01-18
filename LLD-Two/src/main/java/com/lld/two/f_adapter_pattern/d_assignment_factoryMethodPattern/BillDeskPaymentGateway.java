package com.lld.two.f_adapter_pattern.d_assignment_factoryMethodPattern;

import com.lld.two.f_adapter_pattern.payment_gateways.external.BillDeskApi;

public class BillDeskPaymentGateway implements PaymentGateway {
    private BillDeskApi api ;
    public BillDeskPaymentGateway(BillDeskApi api){
        this.api = api;
    }
    @Override
    public void makePayment(PaymentDTO paymentDTO) {
        api.createPayment(paymentDTO.getName(), paymentDTO.getEmail(), paymentDTO.getAccountType(),(int)paymentDTO.getAmount());
    }

    @Override
    public PaymentStatus verifyStatus(Long id) {
        long identifier = id;
        return toPaymentStatus(api.checkStatus((int)identifier));
    }
    //mapper method.
    public static PaymentStatus toPaymentStatus(int status){
        if(status%2==0){
            return PaymentStatus.OK;
        }else{
            return PaymentStatus.ERROR;
        }
    }
}
