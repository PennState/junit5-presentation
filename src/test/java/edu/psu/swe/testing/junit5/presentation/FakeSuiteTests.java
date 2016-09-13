package edu.psu.swe.testing.junit5.presentation;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SuiteTiming.class)
public class FakeSuiteTests {
  
  @BeforeAll
  public static void beforeSuite() {
    System.out.println("Before suite");
  }
  
  @AfterAll
  public static void afterSuite() {
    System.out.println("After suite");
  }
  
  @Nested
  public class FirstTests extends SuiteTestsOne {}
  
  @Nested
  public class SecondTests extends SuiteTestsTwo {}

}
