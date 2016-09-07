/**
 * 
 */
package edu.psu.swe.testing.junit5.presentation.callbacks;

import java.lang.reflect.AnnotatedElement;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ContainerExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExtensionContext;

/**
 * @author smoyer1
 *
 */
public class AllCallbacks implements
    AfterAllCallback,
    AfterEachCallback,
    AfterTestExecutionCallback,
    BeforeAllCallback,
    BeforeEachCallback,
    BeforeTestExecutionCallback {

  /*
   * (non-Javadoc)
   * 
   * @see org.junit.jupiter.api.extension.BeforeTestExecutionCallback#
   * beforeTestExecution(org.junit.jupiter.api.extension.TestExtensionContext)
   */
  @Override
  public void beforeTestExecution(TestExtensionContext context) throws Exception {
    recordCall(context, "BeforeTestExecutionCallback");
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.junit.jupiter.api.extension.BeforeEachCallback#beforeEach(org.junit.
   * jupiter.api.extension.TestExtensionContext)
   */
  @Override
  public void beforeEach(TestExtensionContext context) throws Exception {
    recordCall(context, "BeforeEachCallback");
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.junit.jupiter.api.extension.BeforeAllCallback#beforeAll(org.junit.
   * jupiter.api.extension.ContainerExtensionContext)
   */
  @Override
  public void beforeAll(ContainerExtensionContext context) throws Exception {
    recordCall(context, "BeforeAllCallback");
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.junit.jupiter.api.extension.AfterTestExecutionCallback#
   * afterTestExecution(org.junit.jupiter.api.extension.TestExtensionContext)
   */
  @Override
  public void afterTestExecution(TestExtensionContext context) throws Exception {
    recordCall(context, "AfterTestExecutionCallback");
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.junit.jupiter.api.extension.AfterEachCallback#afterEach(org.junit.
   * jupiter.api.extension.TestExtensionContext)
   */
  @Override
  public void afterEach(TestExtensionContext context) throws Exception {
    recordCall(context, "AfterEachCallback");
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.junit.jupiter.api.extension.AfterAllCallback#afterAll(org.junit.jupiter
   * .api.extension.ContainerExtensionContext)
   */
  @Override
  public void afterAll(ContainerExtensionContext context) throws Exception {
    recordCall(context, "AfterAllCallback");
  }

  void recordCall(ExtensionContext context, String callbackName) {
    System.out.println("AllCallbacks - " + callbackName);
  }

}
