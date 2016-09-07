package edu.psu.swe.testing.junit5.presentation.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.psu.swe.testing.junit5.presentation.affiliates.tests.SampleStudents;

public class SimpleAssertionTests {
	
	void checkStudent() {
		assertEquals("Builder", SampleStudents.getFullTimeStudent().getLastName());
	}
	
	
}
