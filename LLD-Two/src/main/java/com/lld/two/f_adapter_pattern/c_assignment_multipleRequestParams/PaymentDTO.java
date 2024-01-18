package com.lld.two.f_adapter_pattern.c_assignment_multipleRequestParams;

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
