/**
 * 
 */
package edu.psu.swe.testing.junit5.presentation;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * @author smoyer1
 *
 */
@Disabled
@ExtendWith(JunkTestFilter.class)
public class NewCarTests {
  
  @Test
  public void testWhetherSaabsAreNice() {
    System.out.println("testWhetherSaabsAreNice()");
  }
  
  @Test
  public void testWhetherYugosAreJunky() {
    System.out.println("testWhetherYugosAreJunky()");
  }

}
