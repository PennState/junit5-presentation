package edu.psu.swe.testing.junit5.presentation.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import edu.psu.swe.testing.junit5.presentation.supportingcode.CourseUtils;
import edu.psu.swe.testing.junit5.presentation.supportingcode.SampleStudents;
import edu.psu.swe.testing.junit5.presentation.supportingcode.affiliates.models.Student;

public class ParameterizedTests {
  
  private static CourseUtils courseUtils = new CourseUtils();
  
  @RepeatedTest(value=21, name="{displayName} Test {currentRepetition} of {totalRepetitions}")
  @DisplayName("Insanity")
  public void insanity_test() {
      
    Assertions.assertTrue(true);
  }
  
  @RepeatedTest(value=3)
  @DisplayName("Idempotence Test")
  public void idempotence_test() {
    Student student = SampleStudents.getFullTimeStudent();
    
    int calcAge = courseUtils.extractAge(student);
    Assertions.assertEquals(student.getStudentAge(), calcAge, "Age extraction should be Idempotent but is not.");
  }
  
}
