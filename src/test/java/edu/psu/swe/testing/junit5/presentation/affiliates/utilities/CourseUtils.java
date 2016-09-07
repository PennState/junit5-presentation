package edu.psu.swe.testing.junit5.presentation.affiliates.utilities;

import java.util.List;

import edu.psu.swe.testing.junit5.presentation.affiliates.models.Course;
import edu.psu.swe.testing.junit5.presentation.affiliates.models.Student;

public class CourseUtils {

	public static int FULL_TIME = 12;
	public static int MAX_ALLOWED = 25;
	
	public void registerForCourse(Student student, Course course){
		student.addCourse(course);
	}
	
	public int calcStudentLoad(Student student){
		List<Course> courses = student.getCourses();
		int totalCredits = courses.stream().mapToInt(ch->ch.getCreditHours()).sum();
		
		return totalCredits;
	}
}
