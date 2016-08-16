/**
 * 
 */
package edu.psu.swe.testing.junit5.presentation;

import java.lang.reflect.Method;
import java.util.Optional;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

/**
 * @author smoyer1
 *
 */
public class UseridParameterResolver implements ParameterResolver {

  /* (non-Javadoc)
   * @see org.junit.jupiter.api.extension.ParameterResolver#supports(org.junit.jupiter.api.extension.ParameterContext, org.junit.jupiter.api.extension.ExtensionContext)
   */
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

  /* (non-Javadoc)
   * @see org.junit.jupiter.api.extension.ParameterResolver#resolve(org.junit.jupiter.api.extension.ParameterContext, org.junit.jupiter.api.extension.ExtensionContext)
   */
  @Override
  public Object resolve(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
    // TODO Auto-generated method stub
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
