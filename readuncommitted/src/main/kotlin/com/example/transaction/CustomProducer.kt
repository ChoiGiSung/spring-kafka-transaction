package com.example.transaction

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CustomProducer(
    private val kafkaTemplate: KafkaTemplate<String, Any>
) {

    @Transactional
    fun send(userInfo: UserInfo) {
        kafkaTemplate.send("testTopic", userInfo)
        throw RuntimeException("Exception!")
    }

    @Transactional
    fun send(otherInfo: OtherUserInfo) {
        kafkaTemplate.send("testTopic", otherInfo)
    }


    data class UserInfo(
        val name: String,
        val phoneNumber: String,
        val doSomething: String,
    )

    data class OtherUserInfo(
        val address: String,
        val age: Int
    )
}