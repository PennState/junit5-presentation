/**
 * 
 */
package edu.psu.swe.testing.junit5.presentation.tests.extensions;

import java.lang.reflect.Method;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.TestExecutionCondition;
import org.junit.jupiter.api.extension.TestExtensionContext;

public class AfflliateDetector implements TestExecutionCondition {

	@Override
	public ConditionEvaluationResult evaluate(TestExtensionContext context) {
		ConditionEvaluationResult result = ConditionEvaluationResult.enabled("is an affiliate");

		if (context.getTestMethod().isPresent()) {
			Method method = context.getTestMethod().get();
			if (!method.getName().toLowerCase().contains("affiliate")) {
				result = ConditionEvaluationResult.disabled("is not an affiliate");
			}
		}

		return result;
	}

}
