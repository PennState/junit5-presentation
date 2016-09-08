/**
 * 
 */
package edu.psu.swe.testing.junit5.presentation.tests;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;

/*
 * Illustrates extensions with @ExtendWith
 * Also illustrates scenarios for disabling tests at compile and run times
 */

@ExtendWith(AfflliateDetector.class)
public class ExtensionDisabledTests {

	/*
	 * Extension class enables the test and Assumptions passes to run the test
	 */
	@Test
	public void checkStudentAffiliate(TestInfo testInfo) {
		assumeTrue(studentDetector(testInfo));
		System.out.println("checkIfStudentAffiliate passes");
	}

	/*
	 * Extension class disables the test
	 */
	@Test
	public void checkStudent(TestInfo testInfo) {
		assumeTrue(studentDetector(testInfo));
		System.out.println("checkIfStaff disabled by AffiliateDetector extension class");
	}

	/*
	 * Extension class enables the test Assumption fails to disable the test
	 */
	@Test
	public void checkAffiliate(TestInfo testInfo) {
		assumeTrue(studentDetector(testInfo));
		System.out.println("checkAffiliate fails at assumption");
	}

	/*
	 * shows another method to disable the test - with annotation
	 */
	@Test
	@Disabled
	public void checkStaffAffiliate(TestInfo testInfo) {
		assumeTrue(studentDetector(testInfo));
		System.out.println("checkStaffAffiliate is disabled with annotation");
	}

	boolean studentDetector(TestInfo testInfo) {

		boolean methodName = false;

		if (testInfo.getTestMethod().isPresent()) {
			Method method = testInfo.getTestMethod().get();
			methodName = method.getName().toLowerCase().contains("student");
		}

		return methodName;
	}

}
