package com.example.transaction

import org.apache.kafka.common.protocol.Message
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.config.ContainerCustomizer
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer


@Configuration
class Config {

    @Bean
    fun containerCustomizer(
        factory: ConcurrentKafkaListenerContainerFactory<String, Message>
    ): ContainerCustomizer<String, Message, ConcurrentMessageListenerContainer<String, Message>> {
        val cust: ContainerCustomizer<String, Message, ConcurrentMessageListenerContainer<String, Message>> =
            ContainerCustomizer<String, Message, ConcurrentMessageListenerContainer<String, Message>> { container: ConcurrentMessageListenerContainer<String, Message> ->
                container.containerProperties.isFixTxOffsets = true
            }
        factory.setContainerCustomizer(cust)
        return cust
    }
}