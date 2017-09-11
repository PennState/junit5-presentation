package edu.psu.swe.testing.junit5.presentation.tests.extensions;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import edu.psu.swe.testing.junit5.presentation.supportingcode.SampleStudents;
import edu.psu.swe.testing.junit5.presentation.supportingcode.affiliates.models.Student;

public class StudentSimpleParameterResolver implements ParameterResolver {


  @Override
  public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
    boolean supports = false;

    Class<?> parameterClass = parameterContext.getParameter().getType();
    if(parameterClass == String.class || parameterClass == List.class || parameterClass == Stream.class) {
      supports = true;
    }

    return supports;
  }

  

  @Override
  public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
    Object parameter = null;
    Student stud = SampleStudents.getMaxedStudent();
    
    Class<?> parameterClass = parameterContext.getParameter().getType();
    if(parameterClass == Student.class){
      parameter = stud;
      
    }else if(parameterClass == List.class) {
      parameter = stud.getCourses();
      
    }else if(parameterClass == Stream.class) {
      parameter = stud.getCourses().stream();
    }
    
    return parameter;
  }

}
