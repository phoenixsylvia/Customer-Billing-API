package com.phoenix.customerservice;

import lombok.Builder;
import lombok.Data;
import lombok.Value;


import java.math.BigDecimal;

@Data
@Builder
@Value
public class CustomerBillingResponse {
    private Long customerId;
    private BigDecimal amount;
    private Status status;
}
