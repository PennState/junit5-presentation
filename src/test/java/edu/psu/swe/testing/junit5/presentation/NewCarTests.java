/**
 * 
 */
package edu.psu.swe.testing.junit5.presentation;

import static org.junit.jupiter.api.Assumptions.assumeFalse;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * @author smoyer1
 *
 */
@ExtendWith(JunkyTestDetector.class)
public class NewCarTests {
  
  @Test
  public void testWhetherSaabsAreNice(TestInfo testInfo) {
    assumeFalse(testMethodNameContainsWeird(testInfo));
    System.out.println("testWhetherSaabsAreNice()");
  }
  
  @Test
  public void testWhetherYugosAreJunky(TestInfo testInfo) {
    assumeFalse(testMethodNameContainsWeird(testInfo));
    System.out.println("testWhetherYugosAreJunky()");
  }
  
  @Test
  public void testWhetherHermanMuenstersCarIsWeird(TestInfo testInfo) {
    assumeFalse(testMethodNameContainsWeird(testInfo));
    System.out.println("testWhetherHermanMuenstersCarIsWeird()");
  }
  
  boolean testMethodNameContainsWeird(TestInfo testInfo) {
    boolean weird = false;
    
    if(testInfo.getTestMethod().isPresent()) {
      Method method = testInfo.getTestMethod().get();
      weird = method.getName().toLowerCase().contains("weird");
    }
    
    return weird;
  }

}
