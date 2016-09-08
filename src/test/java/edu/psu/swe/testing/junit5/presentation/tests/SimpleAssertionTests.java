package edu.psu.swe.testing.junit5.presentation.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.psu.swe.testing.junit5.presentation.affiliates.tests.SampleStudents;

public class SimpleAssertionTests {
	
	@Test
	void checkStudentLastName() {
		assertEquals("Builder", SampleStudents.getFullTimeStudent().getLastName());
	}
	
	@Test
	void checkStudentFirstName() {
		assertTrue("Bob".equals(SampleStudents.getFullTimeStudent().getFirstName()));
	}
	
	
}
