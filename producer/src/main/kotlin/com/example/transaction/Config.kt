package com.example.transaction

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.ProducerFactory
import org.springframework.kafka.transaction.KafkaTransactionManager
import java.util.*

@Configuration
class Config {
    @Bean
    fun kafkaTransactionManager(producerFactory: ProducerFactory<Any, Any>): KafkaTransactionManager<*, *> {
        val kafkaTransactionManager: KafkaTransactionManager<*, *> = KafkaTransactionManager<Any, Any>(producerFactory)
        kafkaTransactionManager.setTransactionIdPrefix(String.format("tx-%s-", UUID.randomUUID()))
        return kafkaTransactionManager
    }
}