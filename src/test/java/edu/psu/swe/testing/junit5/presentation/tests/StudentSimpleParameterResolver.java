/**
 * 
 */
package edu.psu.swe.testing.junit5.presentation.tests;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import edu.psu.swe.testing.junit5.presentation.affiliates.models.Student;
import edu.psu.swe.testing.junit5.presentation.supportingcode.SampleStudents;

public class StudentSimpleParameterResolver implements ParameterResolver {

  /* (non-Javadoc)
   * @see org.junit.jupiter.api.extension.ParameterResolver#supports(org.junit.jupiter.api.extension.ParameterContext, org.junit.jupiter.api.extension.ExtensionContext)
   */
  @Override
  public boolean supports(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
    boolean supports = false;

    Class<?> parameterClass = parameterContext.getParameter().getType();
    if(parameterClass == String.class || parameterClass == List.class || parameterClass == Stream.class) {
      supports = true;
    }

    return supports;
  }

  
  /* (non-Javadoc)
   * @see org.junit.jupiter.api.extension.ParameterResolver#resolve(org.junit.jupiter.api.extension.ParameterContext, org.junit.jupiter.api.extension.ExtensionContext)
   */
  @Override
  public Object resolve(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
    // TODO Auto-generated method stub
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
