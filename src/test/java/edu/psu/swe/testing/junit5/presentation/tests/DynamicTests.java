package edu.psu.swe.testing.junit5.presentation.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public class DynamicTests {

  @TestFactory
  public Stream<DynamicTest> testOneThroughTen() {
    return Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        .map((i) -> DynamicTest.dynamicTest("Input: " + i, () -> assertTrue(i != 4)));
  }
  
}
