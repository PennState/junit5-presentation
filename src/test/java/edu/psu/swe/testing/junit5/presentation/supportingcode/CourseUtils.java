package edu.psu.swe.testing.junit5.presentation.supportingcode;

import java.util.List;
import java.util.stream.Stream;

import javax.annotation.PreDestroy;

import edu.psu.swe.testing.junit5.presentation.supportingcode.affiliates.models.Course;
import edu.psu.swe.testing.junit5.presentation.supportingcode.affiliates.models.Student;

/*
 * CourseUtils - Utility class to provide methods for registering students for courses.
 */

public class CourseUtils {

  public int age;
	public static int FULL_TIME = 12;
	public static int MAX_ALLOWED = 25;

	@PreDestroy
	public void destroy() {
	  System.out.println("Destroying the CourseUtils object");
	}
	
	public void registerForCourse(Student student, Course course) throws Exception {
				
		int studentCourseLoad = calcStudentLoad(student);
		int courseCredit = course.getCreditHours();
				
		if ((studentCourseLoad + courseCredit) <= CourseUtils.MAX_ALLOWED) {
			student.addCourse(course);
		} else {
			throw new Exception("Can't register student for course. Student would exceed max allowed credits.");
		}

	}

	public int calcStudentLoad(Student student) {
		List<Course> courses = student.getCourses();
		int totalCredits = courses.stream().mapToInt(ch -> ch.getCreditHours()).sum();

		return totalCredits;
	}

	public static String findPrereq(Course course){
		String prereq = null;

		if (course.isPreRequisite()){
			prereq = course.getPreReqCourse();
		}
		
		System.out.println(course.getId() + " prereq is " + prereq);
		
		return prereq;
	}
	
	public Stream<Object> isPreRequisite(Student student) {
		List<Course> courses = student.getCourses();
		Stream<Object> pr = courses.stream().map(ch -> ch.isPreRequisite());
		return pr;
	}
	
	/*
	 * Method to extract the age from the student object. Used to demonstrate
	 * idempotence failure in repeated tests.
	 */
	public int extractAge(Student student) {
	  age = age + student.getStudentAge();
	  return age;
	}
	
}
