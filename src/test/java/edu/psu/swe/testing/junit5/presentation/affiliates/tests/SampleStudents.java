package edu.psu.swe.testing.junit5.presentation.affiliates.tests;

import edu.psu.swe.testing.junit5.presentation.affiliates.models.Student;

public class SampleStudents {

	public static Student getFullTimeStudent(){
		Student engStudent = new Student();
		engStudent.setFirstName("Bob");
		engStudent.setLastName("Builder");
		engStudent.setMiddleName("The");
		engStudent.setMajor("MechEng");
		engStudent.addCourse(BuildTestCourses.emech210());
		engStudent.addCourse(BuildTestCourses.emech211());
		engStudent.addCourse(BuildTestCourses.emech212());
		engStudent.addCourse(BuildTestCourses.math220());
		engStudent.addCourse(BuildTestCourses.stat401());
		
		return engStudent;
	}

	public static Student getPartTimeStudent(){
		Student partTimeStudent = new Student();
		partTimeStudent.setFirstName("Harry");
		partTimeStudent.setLastName("Duncan");
		partTimeStudent.setMiddleName("James");
		partTimeStudent.setMajor("Business");
		partTimeStudent.addCourse(BuildTestCourses.emech210());
		partTimeStudent.addCourse(BuildTestCourses.emech211());
		
		return partTimeStudent;
	}
	
	public static Student getNewFreshman(){
		Student freshman = new Student();
		freshman.setLastName("Blutarsky");
		freshman.setFirstName("John");
		freshman.setMajor("Party Studies");
		
		return freshman;
	}
	
	public static Student getMaxedStudent(){
		Student maxed = new Student();
		maxed.setLastName("Cooper");
		maxed.setFirstName("Sheldon");
		maxed.setMajor("theoretical physics");
		maxed.addCourse(BuildTestCourses.engl213());
		maxed.addCourse(BuildTestCourses.math220());
		maxed.addCourse(BuildTestCourses.stat401());
		maxed.addCourse(BuildTestCourses.chem408());
		maxed.addCourse(BuildTestCourses.insc480());
		maxed.addCourse(BuildTestCourses.emech210());
		maxed.addCourse(BuildTestCourses.span200());
		maxed.addCourse(BuildTestCourses.music421());
		
		return maxed;
	}
}
