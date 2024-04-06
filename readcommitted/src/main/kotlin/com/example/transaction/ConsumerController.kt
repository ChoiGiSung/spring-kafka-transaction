package com.example.transaction

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class ConsumerController(
) {

    @KafkaListener(groupId = "sample-1", topics = ["testTopic"])
    fun consume(user: User) {
        when (user) {
            is UserInfo -> println("user: $user")
            is OtherUserInfo -> println("other user: $user")
        }
    }

    interface User

    data class UserInfo(
        val name: String,
        val phoneNumber: String
    ) : User

    data class OtherUserInfo(
        val address: String,
        val age: Int
    ) : User
}