package com.example.springboot2kafka.config;

import static com.example.springboot2kafka.config.Topics.TOPIC_2_PARTITIONS_1_CONSUMER;
import static com.example.springboot2kafka.config.Topics.TOPIC_2_PARTITIONS_2_CONSUMERS;
import static com.example.springboot2kafka.config.Topics.TOPIC_2_PARTITIONS_2_CONSUMERS_SAME_GROUP;
import static com.example.springboot2kafka.config.Topics.TOPIC_REPLICATED_PARTITION_2;
import static com.example.springboot2kafka.config.Topics.TOPIC_SET_PARTITION_2;
import static com.example.springboot2kafka.config.Topics.TOPIC_SET_REPLICATED_PARTITION_2;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaAdminConfig {

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092,localhost:9093,localhost:9094");
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic topicWith2Partitions1Consumer() {
         return new NewTopic(TOPIC_2_PARTITIONS_1_CONSUMER, 2, (short) 0);
    }

    @Bean
    public NewTopic topicWith2Partitions2Consumers() {
        return new NewTopic(TOPIC_2_PARTITIONS_2_CONSUMERS, 2, (short) 0);
    }

    @Bean
    public NewTopic sameGroupConsumers(){
        return new NewTopic(TOPIC_2_PARTITIONS_2_CONSUMERS_SAME_GROUP, 2, (short) 0);
    }

    @Bean
    public NewTopic topic2Partitions2Set() {
        return new NewTopic(TOPIC_SET_PARTITION_2, 2, (short) 0);
    }

    @Bean
    public NewTopic topicReplicated() {
        return new NewTopic(TOPIC_REPLICATED_PARTITION_2, 2, (short) 1);
    }

    @Bean
    public NewTopic topicSetReplicated() {
        return new NewTopic(TOPIC_SET_REPLICATED_PARTITION_2, 2, (short) 2);
    }
}
