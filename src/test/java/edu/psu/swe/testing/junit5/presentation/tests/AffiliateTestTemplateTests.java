package edu.psu.swe.testing.junit5.presentation.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

import edu.psu.swe.testing.junit5.presentation.supportingcode.affiliates.models.Affilliate;
import edu.psu.swe.testing.junit5.presentation.tests.extensions.AffiliateTestTemplateInvocationContextProvider;

public class AffiliateTestTemplateTests {
	
	@TestTemplate
	@ExtendWith(AffiliateTestTemplateInvocationContextProvider.class)
	void checkAffiliateTestTemplate(Affilliate parameter) {
		
	    assertEquals(Affilliate.class, parameter.getClass().getSuperclass());
	    System.out.println("AffilliateTestTemplate - " + parameter.getClass().getSimpleName() + " is an affiliate");
	    
	}

}
