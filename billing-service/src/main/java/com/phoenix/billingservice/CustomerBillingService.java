package com.phoenix.billingservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class CustomerBillingService {
    private final CustomerBillingRepository customerBillingRepository;

    private final ModelMapper modelMapper;

    private final KafkaTemplate<String, CustomerBillingResponse> kafkaTemplate;

    public void persistCustomerBilling(CustomerBillingResponse customerBillingResponse) {
        Customer customer = modelMapper.map(customerBillingResponse, Customer.class);
        Customer persistedCustomerBilling = customerBillingRepository.save(customer);

        log.info("food order persisted {}", persistedCustomerBilling);
        kafkaTemplate.send("billing-worker-service", );
    }
}
