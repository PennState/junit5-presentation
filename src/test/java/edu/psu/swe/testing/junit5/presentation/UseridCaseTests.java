package edu.psu.swe.testing.junit5.presentation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith(UseridParameterResolver.class)
public class UseridCaseTests {
  
  @UseridTest
  public void testUseridsAreLowercase(String userid, boolean success) {
    String expected = userid.toLowerCase();
    assertEquals(expected.equals(userid), success);
  }

}
