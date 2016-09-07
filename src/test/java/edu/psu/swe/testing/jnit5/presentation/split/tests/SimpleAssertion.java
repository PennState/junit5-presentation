package edu.psu.swe.testing.jnit5.presentation.split.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.psu.swe.testing.junit5.presentation.affiliates.tests.SampleStudents;

public class SimpleAssertion {
	
	void checkStudent() {
		assertEquals("Builder", SampleStudents.getFullTimeStudent().getLastName());
	}
	
	
}
