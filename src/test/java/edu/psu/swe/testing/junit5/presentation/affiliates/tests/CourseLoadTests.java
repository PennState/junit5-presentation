package edu.psu.swe.testing.junit5.presentation.affiliates.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.expectThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.psu.swe.testing.junit5.presentation.affiliates.models.Student;
import edu.psu.swe.testing.junit5.presentation.affiliates.utilities.CourseUtils;

public class CourseLoadTests {

	CourseUtils courseUtils = new CourseUtils();

	@Test
	public void fullTimeStudentTest() {
		Student student = SampleStudents.getFullTimeStudent();

		assertTrue(courseUtils.calcStudentLoad(student) >= courseUtils.FULL_TIME,
				"Tested student has less then the required number of credits to be considered full time.");
	}

	@Test
	public void partTimeStudentTest() {
		Student student = SampleStudents.getPartTimeStudent();

		assertFalse(courseUtils.calcStudentLoad(student) >= courseUtils.FULL_TIME,
				"Tested student has more then the allowed number of credits to be considered part time.");
	}

	// @Disabled
	@Test
	public void maxStudentTest() {
		Student student = SampleStudents.getMaxedStudent();

		assertTrue(courseUtils.calcStudentLoad(student) <= courseUtils.MAX_ALLOWED,
				"Student has more than allowed credit hours.");
	}

	// @Disabled
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

		// System.out.println("course load = " +
		// courseUtils.calcStudentLoad(student));

		assertTrue(courseUtils.calcStudentLoad(student) <= courseUtils.MAX_ALLOWED,
				"Student has more than allowed credit hours.");
	}
	
	@Test
	@DisplayName("assertThrows")
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

	@Test
	@DisplayName("expectThrows")
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