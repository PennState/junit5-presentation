/**
 * 
 */
package edu.psu.swe.testing.junit5.presentation.callbacks;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

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
  public void beforeTestExecution(ExtensionContext context) throws Exception {
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
  public void beforeEach(ExtensionContext context) throws Exception {
    recordCall(context, "BeforeEachCallback");
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.junit.jupiter.api.extension.BeforeAllCallback#beforeAll(org.junit.
   * jupiter.api.extension.ContainerExtensionContext)
   */
  @Override
  public void beforeAll(ExtensionContext context) throws Exception {
    recordCall(context, "BeforeAllCallback");
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.junit.jupiter.api.extension.AfterTestExecutionCallback#
   * afterTestExecution(org.junit.jupiter.api.extension.TestExtensionContext)
   */
  @Override
  public void afterTestExecution(ExtensionContext context) throws Exception {
    recordCall(context, "AfterTestExecutionCallback");
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.junit.jupiter.api.extension.AfterEachCallback#afterEach(org.junit.
   * jupiter.api.extension.TestExtensionContext)
   */
  @Override
  public void afterEach(ExtensionContext context) throws Exception {
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
  public void afterAll(ExtensionContext context) throws Exception {
    recordCall(context, "AfterAllCallback");
  }

  void recordCall(ExtensionContext context, String callbackName) {
    System.out.println("AllCallbacks - " + callbackName);
  }

}
