package edu.psu.swe.testing.junit5.presentation.tests;

import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.psu.swe.testing.junit5.presentation.affiliates.models.Affilliate;
import edu.psu.swe.testing.junit5.presentation.affiliates.models.Staff;
import edu.psu.swe.testing.junit5.presentation.affiliates.models.Student;
import edu.psu.swe.testing.junit5.presentation.supportingcode.BuildTestCourses;


/*
 * Assumptions allow you to skip blocks of code or entire tests tests if the tested criteria is not met.
 */
public class AssumptionTests {

  /*
   * This test runs because the assumeTrue test passes.
   */
	@Test
	@DisplayName("assumeTrue test")
	public void assumeTrueTest() {
		System.out.println("testing assumeTrue");
		Student student = new Student();
		assumeTrue(checkIsStudent(student));
		student.addCourse(BuildTestCourses.engl213());
		System.out.println("ENGL course added");
	}

	
	/*
	 * The assumeFalse test fails so remainder of the test is skipped and the whole test is marked as skipped.
	 * The test does not fail, it is simply skipped.
	 */
	@Test
	@DisplayName("assumeFalse test")
	public void assumeFalseTest() {
		System.out.println("testing assumeFalse skipping the test");
		Student student = new Student();
		assumeFalse(checkIsStudent(student));
		student.addCourse(BuildTestCourses.math220());
		System.out.println("MATH course added");
	}

	
	/*
	 * Here the assumeFalse condition passes so the test is executed.
	 */
	@Test
	@DisplayName("assumeFalse fails test")
	public void assumeFalseFailTest() {
		System.out.println("testing assumeFalse failing");
		Staff staff = new Staff();
		assumeFalse(checkIsStudent(staff));
		staff.setFirstName("NOSKIP");
		System.out.println("staff first name set to " + staff.getFirstName());
	}

	
	/*
	 * assumingThat - When evaluates true, executes wrapped code.
	 */
	@Test
	@DisplayName("assumingThat successful test")
	public void assumingThatPassingTest() {

	  Affilliate person = new Student();

		assumingThat(checkIsStudent(person), () -> {
			System.out.println("The person is a student. Proceeding with assumingThat enclosed code.");
			Student student = (Student) person;
			student.addCourse(BuildTestCourses.music421());
		});
		
		System.out.println("The remaining code in the method gets executed no matter what the result of the assumingThat check.");
	}
	

  /*
   * assumingThat - When evaluates false, ignores code within assumingThat block
   */
  @Test
  @DisplayName("assumingThat failing test")
  public void assumingThatFailingTest() {

    Affilliate person = new Staff();

    assumingThat(checkIsStudent(person), () -> {
      System.out.println("assumingThat is valid");

    });
    
    System.out.println("The remaining code in the method gets executed no matter what the result of the assumingThat check.");
  }

  
	public boolean checkIsStudent(Affilliate affilliate) {
		boolean isStudent = false;
		if (affilliate.getClass().getName().contains("Student")) {
			isStudent = true;
		}
		return isStudent;
	}

}
