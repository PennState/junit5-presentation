package edu.psu.swe.testing.junit5.presentation.affiliates.tests;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNull;
import edu.psu.swe.testing.junit5.presentation.affiliates.models.Course;
import edu.psu.swe.testing.junit5.presentation.affiliates.models.Student;
import edu.psu.swe.testing.junit5.presentation.affiliates.utilities.CourseUtils;

/*
 * Tests to look for prerequisites. The various tests all test the same thing
 * but show the differences in execution.
 */

public class LoopingTests {

	private Student student = SampleStudents.getMaxedStudent();

	@Test
	@DisplayName("Testing using a ForLoop")
	public void courseAddLoopTest(){
		List<Course> courses = student.getCourses();
		System.out.println("\n\r\n\rStart Looping Prereq Test.");
		for (Course currCourse : courses){
			assertTrue(CourseUtils.findPrereq(currCourse) == null, "Course requires prerequisite.");
		}
		System.out.println("End Loooping Prereq Test.");
	}

	@TestFactory
	@DisplayName("Testing using a TestFactory")
	public Stream<DynamicTest> courseAddTestFactoryTest(){
		
		System.out.println("\n\r\n\rStart Test Factory Prereq Test.");
		
		Stream<DynamicTest> factoryTests = student.getCourses().stream().map((c) -> DynamicTest.dynamicTest("Course: " + c.getName(), () -> assertTrue(CourseUtils.findPrereq(c) == null)));
		
		System.out.println("End Test Factory Prereq Test.");
		
		return factoryTests;
	}

	@Test
	@DisplayName("Testing using AssertAll")
	public void courseAddAssertAllTest(){
		System.out.println("\n\r\n\rStart assertAll Prereq Test.");
		
		assertAll(
				student.getCourses().stream()
				.map((c) -> new Executable() {
					@Override
					public void execute() throws Throwable{
						assertNull(CourseUtils.findPrereq(c));
					}
				})
				.collect(Collectors.toList())
				.toArray(new Executable[0]));
		
		System.out.println("End assertAll Prereq Test.");
	}
	
}
