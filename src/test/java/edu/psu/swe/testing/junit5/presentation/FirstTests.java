package edu.psu.swe.testing.junit5.presentation;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.expectThrows;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Executable;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

public class FirstTests {

  @Test
  @Tag("Small")
  @DisplayName("Test that assertEquals() is true when applicable")
  public void testAssertEqualsTrue() {
    assertEquals(2, 2);
  }

  @Test
  @Small
  public void testAssertEqualsFalse() {
    assertNotEquals(2, 3);
  }

  @Test
  @Disabled
  public void testThatWillBlowUp() {
    assertEquals(2, 3);
  }

  @TestFactory
  public Stream<DynamicTest> testOneThroughTen() {
    return Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        .map((i) -> DynamicTest.dynamicTest("Input: " + i, () -> assertTrue(i != 4)));
  }

  @Test
  public void testOneThroughTenByLoop() {
    for (int i = 1; i < 11; i++) {
      assertTrue(i != 4);
    }
  }

  public class UseridParameter {

    String userid;

    boolean success;

    public UseridParameter(String userid, boolean success) {
      this.userid = userid;
      this.success = success;
    }

    public String getUserid() {
      return userid;
    }

    public void setUserid(String userid) {
      this.userid = userid;
    }

    public boolean isSuccess() {
      return success;
    }

    public void setSuccess(boolean success) {
      this.success = success;
    }

  }

  Stream<UseridParameter> getUseridParameters() {
    return Stream.of(
        new UseridParameter("sgs116", true),
        new UseridParameter("sGs116", false),
        new UseridParameter("SGS116", false));
  }

  @TestFactory
  public Stream<DynamicTest> testUseridsAreLowercase() {
    return getUseridParameters()
        .map((p) -> DynamicTest.dynamicTest("Userid: " + p.getUserid(), () -> assertEquals(p.getUserid().toLowerCase().equals(p.getUserid()), p.isSuccess())));
  }

  @Test
  public void testUseridsAreLowercaseWithAssertAll() {
    assertAll(
        () -> assertEquals("sgs116".equals("sgs116"), true, "Trying lowercase"),
        () -> assertEquals("sgs116".equals("sGs116"), true, "Trying mixed-case"),
        () -> assertEquals("sgs116".equals("SGS116"), true, "Trying uppercase"));
  }

  @Test
  public void testUseridsAreLowercaseWithAssertAllUsingExecutable() {
    assertAll(
        getUseridParameters()
            .map((p) -> new Executable() {

              @Override
              public void execute() throws Throwable {
                assertEquals("sgs116".equals(p.getUserid()), p.isSuccess());
              }

            })
            .collect(Collectors.toList())
            .toArray(new Executable[0]));
  }

  @Test
  void exceptionTesting() {
    Throwable exception = expectThrows(IllegalArgumentException.class, () -> {
      throw new IllegalArgumentException("a message");
    });
    assertEquals("a message", exception.getMessage());
  }

  @Test
  void testOnlyOnCiServer() {
    assumeTrue(false);
    // remainder of test
  }

}
