/**
 * 
 */
package edu.psu.swe.testing.junit5.presentation.tests;

/**
 * @author smoyer1
 *
 */
@IncludeClassNamePatterns({ "**/*Tests.java" })
public class ExampleSuite {

	@BeforeAll
	static void setUp() {
	...
	}

	@AfterAll
	static void tearDown() {
	...
	}

}
