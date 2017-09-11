/**
 * 
 */
package edu.psu.swe.testing.junit5.presentation.tests.suite;

import java.lang.reflect.AnnotatedElement;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;

/**
 * @author smoyer1
 *
 */
public class SuiteTiming implements BeforeAllCallback, AfterAllCallback {
  public static final Namespace TIMING = Namespace.create("timing");
  /*
   * (non-Javadoc)
   * 
   * @see
   * org.junit.jupiter.api.extension.AfterAllCallback#afterAll(org.junit.jupiter
   * .api.extension.ContainerExtensionContext)
   */
  @Override
  public void afterAll(ExtensionContext context) throws Exception {
    //System.out.println("SuiteTiming - afterAll()");
    if (isAnnotated(context)) {
      long endTime = System.nanoTime();
      System.out.println("Timing stopped");
      long startTime = (long) context.getStore(TIMING).get("StartTime");
      System.out.println("Run time (nS): " + (endTime - startTime));
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.junit.jupiter.api.extension.BeforeAllCallback#beforeAll(org.junit.
   * jupiter.api.extension.ContainerExtensionContext)
   */
  @Override
  public void beforeAll(ExtensionContext context) throws Exception {
    //System.out.println("SuiteTiming - beforeAll()");
    if (isAnnotated(context)) {
      long startTime = System.nanoTime();
      
      context.getStore(TIMING).put("StartTime", startTime);
      System.out.println("Timing started");
    }
  }

  boolean isAnnotated(ExtensionContext context) {
    boolean annotated = false;

    if (context.getElement().isPresent()) {
      AnnotatedElement element = context.getElement().get();
      ExtendWith annotation = element.getAnnotation(ExtendWith.class);
      if (annotation != null) {
        Class<?>[] clazzes = annotation.value();
        for (Class<?> clazz : clazzes) {
          if (clazz.isAssignableFrom(SuiteTiming.class)) {
            annotated = true;
          }
        }
      }
    }

    return annotated;
  }

}
