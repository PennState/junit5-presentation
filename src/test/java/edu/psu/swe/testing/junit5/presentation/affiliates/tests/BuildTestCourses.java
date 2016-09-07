package edu.psu.swe.testing.junit5.presentation.affiliates.tests;

import edu.psu.swe.testing.junit5.presentation.affiliates.models.Course;

public class BuildTestCourses {

	public static Course stat401() {
		return new Course("STAT401",
	"Statistics for Engineering",
	"This course provides basic statistic analysis tools for engineers.",
	3);
	}
	
	public static Course emech210() {
		return new Course("EMECH210",
	"Statics and Strength of Materials",
	"This course provides basic statc mechanism analysis tools for engineers.",
	3);
	}
	public static Course emech211() {
		return new Course("EMECH211",
	"Statics",
	"This course provides basic statc mechanism analysis tools for engineers.",
	3);
	}
	
	public static Course emech212() {
		return new Course("EMECH212",
	"Dynamics",
	"This course provides basic dynamic mechanism analysis tools for engineers.",
	3);
	}
	
	public static Course math220() {
		return new Course("MATH220",
	"Matrices",
	"Systems of linear equations; matrix algebra; eigenvalues and eigenvectors; linear systems of differential equations.",
	2);
	}
	
	public static Course phil003L() {
		return new Course("PHIL003L",
				"Persons, Moral Values and the Good Life",
				"Major ethical positions and assumptions regarding questions of freedom, choice, obligation, and conflicts in contemporary moral conduct, values, and reasoning.",
				3);
	}
	
	public static Course eng003() {
		return new Course("ENG003",
				"Rhetoric and Composition",
				"Instruction and practice in writing expository prose that shows sensitivity to audience and purpose.",
				3);
	}
}
