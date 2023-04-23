package com.phoenix.customerservice;

import lombok.Value;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic topic(){
        return TopicBuilder
                .name("billing_topics")
                .partitions(1)
                .replicas(1)
                .build();
    }
}
