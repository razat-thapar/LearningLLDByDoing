package com.lld.two.f_adapter_pattern.d_assignment_factoryMethodPattern;

import com.lld.two.f_adapter_pattern.payment_gateways.external.RazorPayApi;

public class RazorPayPaymentGatewayFactory implements PaymentGatewayFactory{

    @Override
    public PaymentGateway createPaymentGateway() {
        return new RazorPayPaymentGateway(new RazorPayApi());
    }
}
