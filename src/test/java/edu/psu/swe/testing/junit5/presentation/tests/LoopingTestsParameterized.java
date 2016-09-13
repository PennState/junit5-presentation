package edu.psu.swe.testing.junit5.presentation.tests;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNull;
import edu.psu.swe.testing.junit5.presentation.affiliates.models.Course;
import edu.psu.swe.testing.junit5.presentation.affiliates.models.Student;
import edu.psu.swe.testing.junit5.presentation.supportingcode.CourseUtils;

/*
 * Tests to look for prerequisites. The various tests all test the same set
 * but show the differences in execution.
 */
@ExtendWith(StudentSimpleParameterResolver.class)
public class LoopingTestsParameterized {

	/*
	 * Simple looping through a collection and testing each condition. This test will run
	 * until the assertion fails then will exit the method without evaluating any further
	 * conditions.
	 */
	@Test
	@DisplayName("Parameterized Testing using a ForLoop")
	public void courseAddLoopTest(Student stud){
	  
		List<Course> courses = stud.getCourses();		
		courseAddLoopTest(courses);
	}

	
	 @Test
	  @DisplayName("Parameterized Testing using a ForLoop")
	  public void courseAddLoopTest(List<Course> courses){
	    for (Course currCourse : courses){
	      assertTrue(CourseUtils.findPrereq(currCourse) == null,
	          "Course requires prerequisite.");
	    }
	  }
	 
	 
	/*
	 * Test using a test factory. This method will generate a series of tests, one for each item
	 * in the collection. The tests will then execute individually. A failure of any one test will
	 * not prevent the remaining tests from being evaluated.
	 */
	@TestFactory
	@DisplayName("Testing using a TestFactory")
	public Stream<DynamicTest> courseAddTestFactoryTest(Stream<Course> courseStream){

		Stream<DynamicTest> factoryTests = courseStream.map((c) -> 
		  DynamicTest.dynamicTest("Course: " + c.getName(), () -> 
		  assertTrue(CourseUtils.findPrereq(c) == null, "Prerequisite requires for this course.")));

		return factoryTests;
	}


	
	/*
	 * This test shows how to use assertAll to evaluate the same collection of data. In this test,
	 * an inner class is used to create a stream of Executable tests. In this test example, all of the 
	 * tests are evaluated but a failure will cause the assertAll to evaluate to false and exit the 
	 * method with no further code being executed. 
	 */
	@Test
	@DisplayName("Parameterized Testing using AssertAll")
	public void courseAddAssertAllTest(Stream<Course> courses){

		assertAll(
		    courses.map((c) -> new Executable() {
					@Override
					public void execute() throws Throwable{
						assertNull(CourseUtils.findPrereq(c));
					}
				})
				.collect(Collectors.toList())
				.toArray(new Executable[0]));
	}
}
