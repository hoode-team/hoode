package vip.hoode;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

// @SpringBootTest
class HoodeApplicationTests {

	@Test
	void contextLoads() {
		System.out.println(Duration.ofMillis(2592000000L));
	}

}
