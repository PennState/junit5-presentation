package edu.psu.swe.testing.junit5.presentation.supportingcode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.psu.swe.testing.junit5.presentation.affiliates.models.Student;

public class CourseLoadTests {

	CourseUtils courseUtils = new CourseUtils();

	@Test
	public void fullTimeStudentTest() {
		Student student = SampleStudents.getFullTimeStudent();

		assertTrue(courseUtils.calcStudentLoad(student) >= CourseUtils.FULL_TIME,
				"Tested student has less then the required number of credits to be considered full time.");
	}

	@Test
	public void partTimeStudentTest() {
		Student student = SampleStudents.getPartTimeStudent();

		assertFalse(courseUtils.calcStudentLoad(student) >= CourseUtils.FULL_TIME,
				"Tested student has more then the allowed number of credits to be considered part time.");
	}

	@Test
	public void maxStudentTest() {
		Student student = SampleStudents.getMaxedStudent();

		assertTrue(courseUtils.calcStudentLoad(student) <= CourseUtils.MAX_ALLOWED,
				"Student has exceeded allowed credit hours.");
	}

/*
 * This test adds courses directly on the student object instead of using the proper
 * addCourse
 */
	@Test
	@DisplayName("student able to register over max credits")
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

		assertTrue(courseUtils.calcStudentLoad(student) <= CourseUtils.MAX_ALLOWED,
				"Student has more than allowed credit hours.");
	}
	

}