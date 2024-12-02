package com.golfclub.golfclubmanagement;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")  // Activates application-test.properties
@SpringBootTest
class GolfClubManagementApplicationTests {

	@Test
	void contextLoads() {
		// This test ensures that the application context loads successfully
	}
}
