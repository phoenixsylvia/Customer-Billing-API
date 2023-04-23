package com.phoenix.billingservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomerBillingConsumer {
    private static final String billingTopic = "${topic.name}";

    private final ObjectMapper objectMapper;
    private final CustomerBillingService customerBillingService;


    @KafkaListener(topics = billingTopic)
    public void consumeMessage(String message) throws Exception {
        log.info("message consumed {}", message);

        CustomerBillingResponse customerBillingResponse = objectMapper.readValue(message, CustomerBillingResponse.class);
        customerBillingService.persistCustomerBilling(customerBillingResponse);

    }
}
