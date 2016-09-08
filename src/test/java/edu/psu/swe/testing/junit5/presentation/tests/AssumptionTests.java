package edu.psu.swe.testing.junit5.presentation.tests;

import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.psu.swe.testing.junit5.presentation.affiliates.models.Affilliate;
import edu.psu.swe.testing.junit5.presentation.affiliates.models.Staff;
import edu.psu.swe.testing.junit5.presentation.affiliates.models.Student;
import edu.psu.swe.testing.junit5.presentation.affiliates.tests.BuildTestCourses;

public class AssumptionTests {

	@Test
	@DisplayName("assumeTrue test")
	public void assumeTrueTest() {
		System.out.println("testing assumeTrue");
		Student student = new Student();
		assumeTrue(checkAffiliateClass(student));
		student.addCourse(BuildTestCourses.engl213());
		System.out.println("ENGL course added");
	}

	/*
	 * assumeFalse passes to skip the test
	 */
	@Test
	@DisplayName("assumeFalse test")
	public void assumeFalseTest() {
		System.out.println("testing assumeFalse skipping the test");
		Student student = new Student();
		assumeFalse(checkAffiliateClass(student));
		student.addCourse(BuildTestCourses.math220());
		System.out.println("MATH course added");
	}

	/*
	 * assumeFalse fails, therefore executing the test
	 */
	@Test
	@DisplayName("assumeFalse fails test")
	public void assumeFalseFailTest() {
		System.out.println("testing assumeFalse failing");
		Staff staff = new Staff();
		assumeFalse(checkAffiliateClass(staff));
		staff.setFirstName("NOSKIP");
		System.out.println("staff first name set to " + staff.getFirstName());
	}

	/*
	 * assumingThat - test passes when the assumption is valid
	 */
	@Test
	@DisplayName("assumingThat test")
	public void assumingThatTest() {

		Student student = new Student();

		assumingThat(checkAffiliateClass(student), () -> {
			System.out.println("assumingThat is valid");
			student.addCourse(BuildTestCourses.music421());
		});

	}

	public boolean checkAffiliateClass(Affilliate affilliate) {
		boolean isStudent = false;
		if (affilliate.getClass().getName().contains("Student")) {
			isStudent = true;
		}
		return isStudent;
	}

}
