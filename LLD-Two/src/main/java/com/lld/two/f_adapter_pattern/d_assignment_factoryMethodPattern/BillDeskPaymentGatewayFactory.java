package com.lld.two.f_adapter_pattern.d_assignment_factoryMethodPattern;

import com.lld.two.f_adapter_pattern.payment_gateways.external.BillDeskApi;

public class BillDeskPaymentGatewayFactory implements PaymentGatewayFactory{

    @Override
    public PaymentGateway createPaymentGateway() {
        return new BillDeskPaymentGateway(new BillDeskApi());
    }
}
