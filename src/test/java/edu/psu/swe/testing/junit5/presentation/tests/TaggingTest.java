package edu.psu.swe.testing.junit5.presentation.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import edu.psu.swe.testing.junit5.presentation.tests.extensions.Small;

public class TaggingTest {

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
  
}
