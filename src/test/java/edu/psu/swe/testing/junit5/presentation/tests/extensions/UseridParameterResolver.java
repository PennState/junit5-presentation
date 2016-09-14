package edu.psu.swe.testing.junit5.presentation.tests.extensions;

import java.lang.reflect.Method;
import java.util.Optional;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class UseridParameterResolver implements ParameterResolver {

  @Override
  public boolean supports(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
    boolean supports = false;
    
    if(extensionContext.getTestMethod().isPresent()) {
      Method method = extensionContext.getTestMethod().get();
      if(method.isAnnotationPresent(UseridTest.class)) {
        Class<?> parameterClass = parameterContext.getParameter().getType();
        if(parameterClass == String.class || parameterClass == boolean.class) {
          supports = true;
        }
      }
    }
    
    return supports;
  }

  @Override
  public Object resolve(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
    Object parameter = null;
    
    Class<?> parameterClass = parameterContext.getParameter().getType();
    if(parameterClass == String.class){
      parameter = new String("sgs116");
    } else if(parameterClass == boolean.class) {
      return true;
    }
    
    return parameter;
  }

}
