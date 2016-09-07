package edu.psu.swe.testing.junit5.presentation.affiliates.tests;

import org.junit.jupiter.api.Test;

import edu.psu.swe.testing.junit5.presentation.affiliates.models.Student;
import edu.psu.swe.testing.junit5.presentation.affiliates.utilities.CourseUtils;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CourseLoadTests {

	@Test
	public void fullTimeStudentTest(){
		Student student = SampleStudents.getFullTimeStudent();
		
		CourseUtils courseUtils = new CourseUtils();
		assertTrue(courseUtils.calcStudentLoad(student) >= courseUtils.FULL_TIME, "Tested student has less then the required number of credits to be considered full time.");
		assertTrue(courseUtils.calcStudentLoad(student) <= courseUtils.MAX_ALLOWED, "Tested student has less then the required number of credits to be considered full time.");
	}
	
	@Test
	public void partTimeStudentTest(){
		Student student = SampleStudents.getPartTimeStudent();
		
		CourseUtils courseUtils = new CourseUtils();
		assertFalse(courseUtils.calcStudentLoad(student) >= courseUtils.FULL_TIME, "Tested student has more then the allowed number of credits to be considered part time.");
	}
}