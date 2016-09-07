package edu.psu.swe.testing.junit5.presentation;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
public abstract class SuiteTestsOne {

  @BeforeAll
  public static void beforeAll() {
    System.out.println("Before all one");
  }
  
  @AfterAll
  public static void afterAll() {
    System.out.println("After all one");
  }
  
  @BeforeEach
  public void beforeEach() {
    System.out.println("Before each one");
  }
  
  @AfterEach
  public void afterEach() {
    System.out.println("After each one");
  }
  
  @Test
  public void testOneOne() {
    System.out.println("test one one");
    assertTrue(true);
  }
  
  @Test
  public void testOneTwo() {
    System.out.println("test one two");
    assertTrue(true);
  }
  
}
