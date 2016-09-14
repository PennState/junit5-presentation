package edu.psu.swe.testing.junit5.presentation.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.extension.ExtendWith;

import edu.psu.swe.testing.junit5.presentation.tests.extensions.UseridParameterResolver;
import edu.psu.swe.testing.junit5.presentation.tests.extensions.UseridTest;


@ExtendWith(UseridParameterResolver.class)
public class UseridCaseTests {
  
  @UseridTest
  public void testUseridsAreLowercase(String userid, boolean success) {
    String expected = userid.toLowerCase();
    assertEquals(expected.equals(userid), success);
  }

}
