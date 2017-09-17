package edu.psu.swe.testing.junit5.presentation.tests.extensions;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import edu.psu.swe.testing.junit5.presentation.supportingcode.affiliates.models.Affilliate;

public class AffilliateParameterResolver implements ParameterResolver {
	
	Affilliate affilliate;
	
	public AffilliateParameterResolver(Affilliate affillate) {
		this.affilliate = affillate;
	}

	@Override
	public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
		return affilliate;
	}

	@Override
	public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
		return parameterContext.getParameter().getType().equals(Affilliate.class);
	}

}
