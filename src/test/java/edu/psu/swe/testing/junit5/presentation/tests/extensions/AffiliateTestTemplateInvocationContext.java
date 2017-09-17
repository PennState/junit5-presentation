package edu.psu.swe.testing.junit5.presentation.tests.extensions;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.TestTemplateInvocationContext;

import edu.psu.swe.testing.junit5.presentation.supportingcode.affiliates.models.Affilliate;

public class AffiliateTestTemplateInvocationContext implements TestTemplateInvocationContext {
	
	Affilliate affilliate;
	
	public AffiliateTestTemplateInvocationContext(Affilliate affillate) {
		this.affilliate = affillate;
	}
	
	@Override
    public String getDisplayName(int invocationIndex) {
        return "AffilliateTestTemplateContext " + invocationIndex + ": " + affilliate.getClass().getSimpleName();
    }

    @Override	    
    @ExtendWith(AffilliateParameterResolver.class)
    public List<Extension> getAdditionalExtensions() {	            	
    	return Arrays.asList(new AffilliateParameterResolver(affilliate));	
    }

}
