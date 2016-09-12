package edu.psu.swe.testing.junit5.presentation.affiliates.tests;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNull;
import edu.psu.swe.testing.junit5.presentation.affiliates.models.Course;
import edu.psu.swe.testing.junit5.presentation.affiliates.models.Student;
import edu.psu.swe.testing.junit5.presentation.affiliates.utilities.CourseUtils;

/*
 * Tests to look for prerequisites. The various tests all test the same set
 * but show the differences in execution.
 */

public class LoopingTests {

	private Student student = SampleStudents.getMaxedStudent();

	/*
	 * Simple looping through a collection and testing each condition. This test will run
	 * until the assertion fails then will exit the method without evaluating any further
	 * conditions.
	 */
	@Test
	@DisplayName("Testing using a ForLoop")
	public void courseAddLoopTest(){
		List<Course> courses = student.getCourses();
		System.out.println("\n\r\n\rStart Looping Prereq Test.");
		for (Course currCourse : courses){
			assertTrue(CourseUtils.findPrereq(currCourse) == null,
			    "Course requires prerequisite.");
		}
		System.out.println("End Loooping Prereq Test.");
	}

	/*
	 * Test using a test factory. This method will generate a series of tests, one for each item
	 * in the collection. The tests will then execute individually. A failure of any one test will
	 * not prevent the remaining tests from being evaluated.
	 */
	@TestFactory
	@DisplayName("Testing using a TestFactory")
	public Stream<DynamicTest> courseAddTestFactoryTest(){

		System.out.println("\n\r\n\rStart Test Factory Prereq Test.");

		Stream<DynamicTest> factoryTests = student.getCourses().stream().map((c) -> 
		  DynamicTest.dynamicTest("Course: " + c.getName(), () -> 
		  assertTrue(CourseUtils.findPrereq(c) == null, "Prerequisite requires for this course.")));

		System.out.println("End Test Factory Prereq Test.");

		return factoryTests;
	}


	/*
	 * This test shows how to use assertAll to evaluate the same collection of data. In this test,
	 * an inner class is used to create a stream of Executable tests. In this test example, all of the 
	 * tests are evaluated but a failure will cause the assertAll to evaluate to false and exit the 
	 * method with no further code being executed. 
	 */
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


	/*
	 * Finally showing AssertAll by explicitly creating tests for each condition
	 * individually. This is the verbose form of the dynamic form above and is equivalent.
	 */
	@Test
	@DisplayName("AssertAll Verbose Form")
	public void courseAssertAllVerbose(){
		System.out.println("\n\r\n\rStart assertAll Verbose Prereq Test.");	

		assertAll("course",
				() -> assertNull(CourseUtils.findPrereq(BuildTestCourses.engl213())),
				() -> assertNull(CourseUtils.findPrereq(BuildTestCourses.math220())),
				() -> assertNull(CourseUtils.findPrereq(BuildTestCourses.stat401())),
				() -> assertNull(CourseUtils.findPrereq(BuildTestCourses.chem408())),
				() -> assertNull(CourseUtils.findPrereq(BuildTestCourses.insc480())),
				() -> assertNull(CourseUtils.findPrereq(BuildTestCourses.emech210())),
				() -> assertNull(CourseUtils.findPrereq(BuildTestCourses.span200())),
				() -> assertNull(CourseUtils.findPrereq(BuildTestCourses.music421()))
				);

		System.out.println("End assertAll Prereq Test.");
	}
}
