/**
 * 
 */
package edu.psu.swe.testing.junit5.presentation.tests;

/**
 * @author smoyer1
 *
 */
public class ExampleRestTests {

	@UpRest
	@Paths({ "/api/first-resource", "/api/second-resource", "/api/third-resource" })
	@Methods({ Method.POST, Method.PUT, Method.PATCH, Method.DELETE })
	@Headers("Accept:application/json")
	@Authenticator(Oauth2Authenticator.class)
	public void dynamicTest(StatusLine status) {
		assertThat(status).hasStatusCode(HttpStatus.SC_FORBIDDEN);
	}

}
