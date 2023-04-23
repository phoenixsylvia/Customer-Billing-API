package com.phoenix.customerservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class CustomerProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerProducer.class);

    private final NewTopic topic;

    private final KafkaTemplate<String, CustomerBillingResponse> kafkaTemplate;

    public void sendMessage(CustomerBillingResponse customerBillingRequest) throws JsonProcessingException {
        LOGGER.info(String.format("Order event => %s", customerBillingRequest.toString()));

        // create Message
        Message<CustomerBillingResponse> message = MessageBuilder
                .withPayload(customerBillingRequest)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();
        kafkaTemplate.send("billing_topics", message.getPayload());
    }

}
