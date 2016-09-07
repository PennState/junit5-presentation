package edu.psu.swe.testing.junit5.presentation.affiliates.utilities;

import java.util.List;
import java.util.stream.Stream;

import edu.psu.swe.testing.junit5.presentation.affiliates.models.Course;
import edu.psu.swe.testing.junit5.presentation.affiliates.models.Student;

public class CourseUtils {

	public static int FULL_TIME = 12;
	public static int MAX_ALLOWED = 25;

	public void registerForCourse(Student student, Course course) throws Exception {
				
		int studentCourseLoad = calcStudentLoad(student);
		int courseCredit = course.getCreditHours();
		
		System.out.println("load  = " + studentCourseLoad);
		
		if ((studentCourseLoad + courseCredit) <= CourseUtils.MAX_ALLOWED) {
			System.out.println("allowed to register for " + course.getId());
			student.addCourse(course);
		} else {
			System.out.println(course + "exceeding credit limit");
			throw new Exception("can't register as student is excedding max allowed creits");
		}

	}

	public int calcStudentLoad(Student student) {
		List<Course> courses = student.getCourses();
		int totalCredits = courses.stream().mapToInt(ch -> ch.getCreditHours()).sum();

		return totalCredits;
	}

	public Stream<Object> isPreRequisite(Student student) {
		List<Course> courses = student.getCourses();
		Stream<Object> pr = courses.stream().map(ch -> ch.isPreRequisite());
		return pr;
	}
}
