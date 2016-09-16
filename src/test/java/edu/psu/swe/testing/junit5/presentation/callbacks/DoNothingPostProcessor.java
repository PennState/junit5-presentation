package edu.psu.swe.testing.junit5.presentation.callbacks;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

public class DoNothingPostProcessor implements TestInstancePostProcessor {

  @Override
  public void postProcessTestInstance(Object testInstance, ExtensionContext context) throws Exception {
    System.out.println("DoNothingPostProcessor - postProcessTestInstance()");
  }

}
