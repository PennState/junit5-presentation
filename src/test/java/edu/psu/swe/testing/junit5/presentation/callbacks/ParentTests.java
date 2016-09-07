/**
 * 
 */
package edu.psu.swe.testing.junit5.presentation.callbacks;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

/**
 * @author smoyer1
 *
 */
@RunWith(JUnitPlatform.class)
@ExtendWith(AllCallbacks.class)
public class ParentTests {

  @BeforeAll
  public static void beforeAllParent() {
    System.out.println("    Parent - beforeAll()");
  }
  
  @AfterAll
  public static void afterAllParent() {
    System.out.println("    Parent - afterAll()");
  }

  @BeforeEach
  public void beforeEachParent() {
    System.out.println("    Parent - beforeEach()");
  }
  
  @AfterEach
  public void afterEachParent() {
    System.out.println("    Parent - afterEach()");
  }
  
  @Test
  public void test1() {
    System.out.println("    Parent - test1()");
  }
  
  @Test
  public void test2() {
    System.out.println("    Parent - test2()");
  }

}
