package edu.psu.swe.testing.junit5.presentation.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.psu.swe.testing.junit5.presentation.affiliates.tests.SampleStudents;

public class SimpleAssertionTests {
	
	@Test
	void checkStudent() {
		assertEquals("Builder", SampleStudents.getFullTimeStudent().getLastName());
	}
	
	
}
