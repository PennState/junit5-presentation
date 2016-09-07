/**
 * 
 */


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * @author smoyer1
 *
 */
@Disabled
public class ParentTests {

  @BeforeAll
  public static void beforeAllParent() {
    System.out.println("Parent - beforeAll()");
  }
  
  @AfterAll
  public static void afterAllParent() {
    System.out.println("Parent - afterAll()");
  }

  @BeforeEach
  public void beforeEachParent() {
    System.out.println("Parent - beforeEach()");
  }
  
  @AfterEach
  public void afterEachParent() {
    System.out.println("Parent - afterEach()");
  }
  
  @Test
  public void test1() {
    System.out.println("Parent - test1()");
  }

}
