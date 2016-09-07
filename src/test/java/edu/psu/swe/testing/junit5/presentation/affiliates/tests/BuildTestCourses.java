package edu.psu.swe.testing.junit5.presentation.affiliates.tests;

import edu.psu.swe.testing.junit5.presentation.affiliates.models.Course;

public class BuildTestCourses {

	public static Course stat401() {
		return new Course("STAT401",
	"Statistics for Engineering",
	"This course provides basic statistic analysis tools for engineers.",
	3, 
	true);
	}
	
	public static Course emech210() {
		return new Course("EMECH210",
	"Statics and Strength of Materials",
	"This course provides basic statc mechanism analysis tools for engineers.",
	3,
	false);
	}
	public static Course emech211() {
		return new Course("EMECH211",
	"Statics",
	"This course provides basic statc mechanism analysis tools for engineers.",
	3,false);
	}
	
	public static Course emech212() {
		return new Course("EMECH212",
	"Dynamics",
	"This course provides basic dynamic mechanism analysis tools for engineers.",
	3,
	false);
	}
	
	public static Course math220() {
		return new Course("MATH220",
	"Matrices",
	"Systems of linear equations; matrix algebra; eigenvalues and eigenvectors; linear systems of differential equations.",
	2,
	false);
	}
}
