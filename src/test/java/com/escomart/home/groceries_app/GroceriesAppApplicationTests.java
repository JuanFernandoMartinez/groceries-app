package com.escomart.home.groceries_app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(TestContainersConfiguration.class)
class GroceriesAppApplicationTests {



	@Test
	void contextLoads() {
	}

}
