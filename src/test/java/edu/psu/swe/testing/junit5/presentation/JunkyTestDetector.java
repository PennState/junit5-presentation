/**
 * 
 */
package edu.psu.swe.testing.junit5.presentation;

import java.lang.reflect.Method;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.TestExecutionCondition;
import org.junit.jupiter.api.extension.TestExtensionContext;

/**
 * @author smoyer1
 *
 */
public class JunkyTestDetector implements TestExecutionCondition {

  /* (non-Javadoc)
   * @see org.junit.jupiter.api.extension.TestExecutionCondition#evaluate(org.junit.jupiter.api.extension.TestExtensionContext)
   */
  @Override
  public ConditionEvaluationResult evaluate(TestExtensionContext context) {
    ConditionEvaluationResult result = ConditionEvaluationResult.enabled("This test is not junky");
    
    if(context.getTestMethod().isPresent()) {
      Method method = context.getTestMethod().get();
      if(method.getName().toLowerCase().contains("junk")) {
        result = ConditionEvaluationResult.disabled("This test is junky");
      }
    }
    
    return result;
  }

}
