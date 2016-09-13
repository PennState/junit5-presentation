package edu.psu.swe.testing.junit5.presentation.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.expectThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.psu.swe.testing.junit5.presentation.affiliates.models.Student;
import edu.psu.swe.testing.junit5.presentation.supportingcode.BuildTestCourses;
import edu.psu.swe.testing.junit5.presentation.supportingcode.CourseUtils;
import edu.psu.swe.testing.junit5.presentation.supportingcode.SampleStudents;

/*
 * This class provides examples of how to use assertThrows and
 * expectException, along with an explanation of the differences
 * between the two test types.
 */


public class ExceptionTests {

	CourseUtils courseUtils = new CourseUtils();

	/*
	 * Register a student for classes. If the student attempts to add more credit hours
	 * than is permitted, the registerForCourse method will throw an exception. 
	 * Catch the exception and check the type. This is the JUnit 4 way of handling
	 * the exception.
	 */
	@Test
	@DisplayName("register-course-assertion-test")
	public void addCourseTest() {
	  Student student = SampleStudents.getNewFreshman();

	  try {
	    courseUtils.registerForCourse(student, BuildTestCourses.engl213());
	    courseUtils.registerForCourse(student, BuildTestCourses.math220());
	    courseUtils.registerForCourse(student, BuildTestCourses.stat401());
	    courseUtils.registerForCourse(student, BuildTestCourses.chem408());
	    courseUtils.registerForCourse(student, BuildTestCourses.insc480());
	    courseUtils.registerForCourse(student, BuildTestCourses.emech210());
	    courseUtils.registerForCourse(student, BuildTestCourses.span200());
	    courseUtils.registerForCourse(student, BuildTestCourses.music421());

	  } catch (Exception e) {
	    System.out.println(e.getClass().getName());
	    assertTrue(e.getClass().getName().equals("java.lang.Exception"));
	  }

	  assertTrue(courseUtils.calcStudentLoad(student) <= CourseUtils.MAX_ALLOWED,
	      "Student has more than allowed credit hours.");
	}

	/*
	 * Asserts that an exception is thrown when student registers over credit
	 * limits. The asertThrows test only checks that the exception class thrown
	 * matches the expected exception class indicated. 
	 */
	@Test
	@DisplayName("assertThrows-test")
	public void registerCourseTest1() {
		Student student = SampleStudents.getNewFreshman();

		CourseUtils courseUtils = new CourseUtils();

		assertThrows(Exception.class, () -> {
			courseUtils.registerForCourse(student, BuildTestCourses.engl213());
			courseUtils.registerForCourse(student, BuildTestCourses.math220());
			courseUtils.registerForCourse(student, BuildTestCourses.stat401());
			courseUtils.registerForCourse(student, BuildTestCourses.chem408());
			courseUtils.registerForCourse(student, BuildTestCourses.insc480());
			courseUtils.registerForCourse(student, BuildTestCourses.emech210());
			courseUtils.registerForCourse(student, BuildTestCourses.span200());
			courseUtils.registerForCourse(student, BuildTestCourses.music421());
		});
		
	}

	/*
	 * Expects to receive an exception of the class type indicated. The difference 
	 * from assertThrows is that the exception is returned and can be further examined
	 * for additional criteria.
	 */
	@Test
	@DisplayName("expectThrows-test")
	public void registerCourseTest2() {
		Student student = SampleStudents.getNewFreshman();

		CourseUtils courseUtils = new CourseUtils();

		Throwable exception = expectThrows(Exception.class, () -> {
			courseUtils.registerForCourse(student, BuildTestCourses.engl213());
			courseUtils.registerForCourse(student, BuildTestCourses.math220());
			courseUtils.registerForCourse(student, BuildTestCourses.stat401());
			courseUtils.registerForCourse(student, BuildTestCourses.chem408());
			courseUtils.registerForCourse(student, BuildTestCourses.insc480());
			courseUtils.registerForCourse(student, BuildTestCourses.emech210());
			courseUtils.registerForCourse(student, BuildTestCourses.span200());
			courseUtils.registerForCourse(student, BuildTestCourses.music421());
		});
		
		assertEquals("Can't register student for course. Student would exceed max allowed credits.", exception.getMessage());
		
	}
}