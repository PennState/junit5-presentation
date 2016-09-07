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
	
	public static Course engl213() {
		return new Course("ENGL213",
	"Introduction to poetry writing",
	"Students will learn about the practice of poetry in our American traditions.",
	3,
	false);
	}

	public static Course chem408() {
		return new Course("CHEM408",
	"Computational Chemistry",
	"Introduction to numerical and nonnumerical computer uses in physical science.",
	3,
	true);
	}
	
	public static Course insc480() {
		return new Course("INSC480",
	"Software Development Lifecycle",
	"Modern Software Development Techniques and Processes.",
	3,
	true);
	}
	
	public static Course insc561() {
		return new Course("INSC561",
	"Web Security and Privacy",
	"A web-centric look at the latest techniques and practices in computer security as they apply to the Internet.",
	3,
	true);
	}
	
	public static Course span200() {
		return new Course("SPAN200",
	" Intensive Grammar and Composition",
	"Intensive grammar review; composition. Designed primarily for majors and prospective majors.",
	3,
	false);
	}
	
	public static Course music421() {
		return new Course("MUSIC421",
	" Jazz Combo Class",
	"Study and performance of small group jazz.",
	1,
	false);
	}
	
}
