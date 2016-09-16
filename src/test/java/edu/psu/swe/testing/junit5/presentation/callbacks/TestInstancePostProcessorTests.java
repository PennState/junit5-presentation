package edu.psu.swe.testing.junit5.presentation.callbacks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({
    AllCallbacks.class,
    DoNothingPostProcessor.class
})
public class TestInstancePostProcessorTests {

  @Test
  public void test1() {
    System.out.println("TestInstancePostProcessorTests - test1()");
  }

}
