/**
 * 
 */
package edu.psu.swe.testing.junit5.presentation;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author smoyer1
 *
 */
public class ChildTests extends ParentTests {

  @BeforeAll
  public static void beforeAllChild() {
    System.out.println("Child - beforeAll()");
  }
  
  @AfterAll
  public static void afterAllChild() {
    System.out.println("Child - afterAll()");
  }

  @BeforeEach
  public void beforeEachChild() {
    System.out.println("Child - beforeEach()");
  }
  
  @AfterEach
  public void afterEachChild() {
    System.out.println("Child - afterEach()");
  }
  
  @Test
  public void test1() {
    System.out.println("Child - test1()");
  }

  @Test
  public void test2() {
    System.out.println("Child - test2()");
  }

}
