package edu.psu.swe.testing.junit5.presentation.affiliates.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import edu.psu.swe.testing.junit5.presentation.affiliates.models.Student;
import edu.psu.swe.testing.junit5.presentation.affiliates.utilities.CourseUtils;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CourseLoadTests {
	
	CourseUtils courseUtils = new CourseUtils();
	
	@Test
	public void fullTimeStudentTest(){
		Student student = SampleStudents.getFullTimeStudent();
		
		assertTrue(courseUtils.calcStudentLoad(student) >= courseUtils.FULL_TIME, "Tested student has less then the required number of credits to be considered full time.");
	}
	
	@Test
	public void partTimeStudentTest(){
		Student student = SampleStudents.getPartTimeStudent();
		
		assertFalse(courseUtils.calcStudentLoad(student) >= courseUtils.FULL_TIME, "Tested student has more then the allowed number of credits to be considered part time.");
	}
	
	@Disabled
	@Test
	public void maxStudentTest(){
		Student student  = SampleStudents.getMaxedStudent();
		
		assertTrue(courseUtils.calcStudentLoad(student) <= courseUtils.MAX_ALLOWED, "Student has more than allowed credit hours.");
	}
	
	@Disabled
	@Test
	public void addCourseTest(){
		Student student = SampleStudents.getNewFreshman();
		
		student.addCourse(BuildTestCourses.emech210());
		//Add more to max
		
		assertTrue(courseUtils.calcStudentLoad(student) <= courseUtils.MAX_ALLOWED, "Student has more than allowed credit hours.");
	}
}