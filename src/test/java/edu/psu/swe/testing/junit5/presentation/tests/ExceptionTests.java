package edu.psu.swe.testing.junit5.presentation.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.expectThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.psu.swe.testing.junit5.presentation.affiliates.models.Student;
import edu.psu.swe.testing.junit5.presentation.affiliates.utilities.CourseUtils;
import edu.psu.swe.testing.junit5.presentation.supportingcode.BuildTestCourses;
import edu.psu.swe.testing.junit5.presentation.supportingcode.SampleStudents;

//Asserts exceptions
public class ExceptionTests {

	CourseUtils courseUtils = new CourseUtils();

	/*
	 * student is allowed to register as many courses and asserts if registered
	 * courses exceed maximum credits.
	 */
	@Test
	@DisplayName("register-course-assertion-test")
	public void addCourseTest() {
		Student student = SampleStudents.getNewFreshman();

		student.addCourse(BuildTestCourses.emech210());

		student.addCourse(BuildTestCourses.engl213());
		student.addCourse(BuildTestCourses.math220());
		student.addCourse(BuildTestCourses.stat401());
		student.addCourse(BuildTestCourses.chem408());
		student.addCourse(BuildTestCourses.insc480());
		student.addCourse(BuildTestCourses.emech210());
		student.addCourse(BuildTestCourses.span200());
		student.addCourse(BuildTestCourses.music421());
		student.addCourse(BuildTestCourses.emech211());

		assertTrue(courseUtils.calcStudentLoad(student) <= courseUtils.MAX_ALLOWED,
				"Student has more than allowed credit hours.");
	}

	/*
	 * asserts that an exception is thrown when student registers over credit
	 * limits.
	 */
	@Test
	@DisplayName("assertThrows-test")
	void registerCourseTest1() {
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
	 * examines the thrown exception when student registers over credit limits.
	 */
	@Test
	@DisplayName("expectThrows-test")
	void registerCourseTest2() {
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
		assertEquals("can't register as student is excedding max allowed creits", exception.getMessage());

	}

}