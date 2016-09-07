package edu.psu.swe.testing.junit5.presentation.affiliates.models;

import java.util.ArrayList;
import java.util.List;

public class Student extends Affilliate{

	private String major;
	private Staff advisor;
	private List<Course> courses;
	private int semesterNumber;
	
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public Staff getAdvisor() {
		return advisor;
	}
	public void setAdvisor(Staff advisor) {
		this.advisor = advisor;
	}
	public List<Course> getCourses() {
		if (courses == null){
			courses = new ArrayList<Course>();
		}
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public void addCourse(Course course){
		if (courses == null){
			courses = new ArrayList<Course>();
		}
		
		if (course != null){
			courses.add(course);
		}
	}
	public int getSemesterNumber() {
		return semesterNumber;
	}
	public void setSemesterNumber(int semesterNumber) {
		this.semesterNumber = semesterNumber;
	}
	
	
}
