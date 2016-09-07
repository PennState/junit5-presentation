package edu.psu.swe.testing.junit5.presentation;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
public abstract class SuiteTestsTwo {

  @BeforeAll
  public static void beforeAll() {
    System.out.println("Before all two");
  }
  
  @AfterAll
  public static void afterAll() {
    System.out.println("After all two");
  }
  
  @BeforeEach
  public void beforeEach() {
    System.out.println("Before each two");
  }
  
  @AfterEach
  public void afterEach() {
    System.out.println("After each two");
  }
  
  @Test
  public void testTwoOne() {
    System.out.println("test two one");
    assertTrue(true);
  }
  
  @Test
  public void testTwoTwo() {
    System.out.println("test two two");
    assertTrue(true);
  }
  
}
