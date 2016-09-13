
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@Disabled
@RunWith(JUnitPlatform.class)
public class DynamicTests {

  @TestFactory
  public Stream<DynamicTest> testOneThroughTen() {
    return Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        .map((i) -> DynamicTest.dynamicTest("Input: " + i, () -> assertTrue(i != 4)));
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

  @TestFactory
  public Stream<DynamicTest> testUseridsAreLowercaseAgain() {
    return DynamicTest.stream(
        getUseridParameters().iterator(),
        p -> "Userid: " + p.getUserid(),
        p -> assertEquals(p.getUserid().toLowerCase().equals(p.getUserid()), p.isSuccess()));
  }

}
