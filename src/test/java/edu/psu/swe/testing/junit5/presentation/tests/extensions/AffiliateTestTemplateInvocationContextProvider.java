package edu.psu.swe.testing.junit5.presentation.tests.extensions;

import java.util.stream.Stream;

import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContextProvider;

import edu.psu.swe.testing.junit5.presentation.supportingcode.affiliates.models.Staff;
import edu.psu.swe.testing.junit5.presentation.supportingcode.affiliates.models.Student;

public class AffiliateTestTemplateInvocationContextProvider implements TestTemplateInvocationContextProvider {

	@Override
	public boolean supportsTestTemplate(ExtensionContext context) {
		if (context.getTestMethod().get().isAnnotationPresent(TestTemplate.class)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Stream<TestTemplateInvocationContext> provideTestTemplateInvocationContexts(ExtensionContext context) {
		
		Student student = new Student();
		Staff staff = new Staff();
		AffiliateTestTemplateInvocationContext studentTestTemplateContext = new AffiliateTestTemplateInvocationContext(student);
		AffiliateTestTemplateInvocationContext staffTestTemplateContext = new AffiliateTestTemplateInvocationContext(staff);
		
		return Stream.of(studentTestTemplateContext, staffTestTemplateContext);
		
	}

}
