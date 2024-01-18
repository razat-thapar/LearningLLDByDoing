package com.lld.two.f_adapter_pattern.d_assignment_factoryMethodPattern;

import com.lld.two.f_adapter_pattern.payment_gateways.external.AccountType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PaymentDTO {
    private long id;
    private String name;
    private AccountType accountType;
    private String email ;
    private double amount;

}
