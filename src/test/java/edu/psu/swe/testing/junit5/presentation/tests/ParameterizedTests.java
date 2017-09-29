package edu.psu.swe.testing.junit5.presentation.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import edu.psu.swe.testing.junit5.presentation.supportingcode.CourseUtils;
import edu.psu.swe.testing.junit5.presentation.supportingcode.SampleStudents;
import edu.psu.swe.testing.junit5.presentation.supportingcode.affiliates.models.Student;

public class ParameterizedTests {
  
  private static CourseUtils courseUtils = new CourseUtils();
  
  @Disabled
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
  
  @ParameterizedTest
  @CsvFileSource(resources = "/data/students_course.csv")
  void testWithCsvFileSource(String first, String second, String major, String credits, String courseName) {
      assertNotNull(first);
      
  } 
  
  @ParameterizedTest
  @CsvSource(value = {"Cooper, Sheldon", "Builder, Bob", "Blutarsky, John"})
  void csvSourceTest(String lastName, String firstName) {
    System.out.println(lastName + ", " + firstName);
  }
  
  @ParameterizedTest
  @ValueSource(strings = {"Cooper", "Sheldon", "Builder", "Bob", "Blutarsky", "John"})
  void valueSourceTest(String name) {
    System.out.println(name);
  }
  
  @ParameterizedTest
  @MethodSource("studentNameAgeData")
  void methodSourceTest(String firstName, String lastName, int age) {
    System.out.println(firstName + " " + lastName + ", " + age);
  }
  
  private static Stream<Arguments> studentNameAgeData(){
    Student sheldon = SampleStudents.getMaxedStudent();
    Student john = SampleStudents.getNewFreshman();
    return Stream.of(sheldon, john)
        .map(s -> Arguments.of(s.getFirstName(), s.getLastName(), s.getStudentAge()));
  }
}
