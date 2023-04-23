package com.phoenix.customerservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerProducer customerProducer;
    public String sendBillingRequest(CustomerBillingResponse customerBillingRequest) throws JsonProcessingException {

        customerBillingRequest.builder()
                .customerId(customerBillingRequest.getCustomerId())
                .amount(customerBillingRequest.getAmount())
                .status(Status.PENDING)
                .build();
        customerProducer.sendMessage(customerBillingRequest);
        return "Customer billing request sent successfully ...";


    }
}
