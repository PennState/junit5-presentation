/**
 * 
 */
package edu.psu.swe.testing.junit5.presentation;

import java.lang.reflect.AnnotatedElement;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ContainerExtensionContext;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * @author smoyer1
 *
 */
public class SuiteTiming implements BeforeAllCallback, AfterAllCallback {

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.junit.jupiter.api.extension.AfterAllCallback#afterAll(org.junit.jupiter
   * .api.extension.ContainerExtensionContext)
   */
  @Override
  public void afterAll(ContainerExtensionContext context) throws Exception {
    //System.out.println("SuiteTiming - afterAll()");
    if (isAnnotated(context)) {
      long endTime = System.nanoTime();
      System.out.println("Timing stopped");
      long startTime = (long) context.getStore().get("StartTime");
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
  public void beforeAll(ContainerExtensionContext context) throws Exception {
    //System.out.println("SuiteTiming - beforeAll()");
    if (isAnnotated(context)) {
      long startTime = System.nanoTime();
      context.getStore().put("StartTime", startTime);
      System.out.println("Timing started");
    }
  }

  boolean isAnnotated(ContainerExtensionContext context) {
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
