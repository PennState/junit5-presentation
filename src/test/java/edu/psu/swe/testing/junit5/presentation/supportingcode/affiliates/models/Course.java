package edu.psu.swe.testing.junit5.presentation.supportingcode.affiliates.models;

public class Course {

	private String id;
	private String name;
	private String description;
	private int creditHours;
	private boolean preRequisite;
	private String preReqCourse;
	
	public Course(String id, String name, String description, int creditHours, boolean preRequisite) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.creditHours = creditHours;
		this.preRequisite=preRequisite;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCreditHours() {
		return creditHours;
	}
	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}
	public boolean isPreRequisite() {
		return preRequisite;
	}
	public void setPreRequisite(boolean preRequisite) {
		this.preRequisite = preRequisite;
	}
	public String getPreReqCourse() {
		return preReqCourse;
	}
	public void setPreReqCourse(String preReqCourse) {
		this.preReqCourse = preReqCourse;
	}
		
}
