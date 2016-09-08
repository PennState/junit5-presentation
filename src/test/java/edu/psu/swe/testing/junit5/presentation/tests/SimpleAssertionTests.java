package edu.psu.swe.testing.junit5.presentation.tests;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.psu.swe.testing.junit5.presentation.affiliates.models.Student;
import edu.psu.swe.testing.junit5.presentation.affiliates.tests.SampleStudents;

public class SimpleAssertionTests {

	@Test
	@DisplayName("assertEquals test")
	void checkStudentLastName() {
		assertEquals("Builder", SampleStudents.getFullTimeStudent().getLastName());
	}

	@Test
	@DisplayName("assertTrue test")
	void checkStudentFirstName() {
		assertTrue("Bob".equals(SampleStudents.getFullTimeStudent().getFirstName()));
	}

	@Test
	@DisplayName("assertTrue test - lambda")
	void checkforNull() {
		Student newStudent = SampleStudents.getNewFreshman();
		// newStudent.addCourse(BuildTestCourses.chem408());
		assertTrue(newStudent.getCourses().size() == 0,
				() -> "new student (" + newStudent.getFirstName() + ") should have 0 credits.");
	}

	/*
	 * all assertions are evaluated even if one fails in the middle
	 */
	@Test
	@DisplayName("grouped Assertions test")
	void groupedAssertion() {
		Student newStudent = SampleStudents.getNewFreshman();
		assertAll("newStudent", 
				()-> assertEquals(0, newStudent.getCourses().size()),
				() -> assertEquals("John", newStudent.getFirstName()),
				() -> assertEquals("Blutarsky", newStudent.getLastName())
		);

	}

}
