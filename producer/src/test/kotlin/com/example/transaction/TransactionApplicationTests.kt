package com.example.transaction

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class TransactionApplicationTests {

	@Autowired
	lateinit var producer: CustomProducer

	// [error, success] -> 0 lag
	@Test
	fun errorFirst() {
		producer.send(CustomProducer.OtherUserInfo("name2", 12))
		producer.send(CustomProducer.UserInfo("name1", "010-1234-5678", "demo"))
	}

	// [success, error] -> 2 lag
	@Test
	fun errorSecond() {
		producer.send(CustomProducer.UserInfo("name1", "010-1234-5678", "demo"))
		producer.send(CustomProducer.OtherUserInfo("홍길동", 12))
	}

	@Test
	fun success() {
		producer.send(CustomProducer.UserInfo("name1", "010-1234-5678", "demo"))
	}

	@Test
	fun fail() {
		producer.send(CustomProducer.OtherUserInfo("홍길동", 12))
	}

}
