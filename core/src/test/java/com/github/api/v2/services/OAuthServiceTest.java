/*
 * 
 */
package com.github.api.v2.services;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.EnumSet;

import com.github.api.v2.services.OAuthService.Permission;
import com.github.api.v2.services.constant.TestConstants;

/**
 * The Class FacebookOAuthServiceTest.
 */
public class OAuthServiceTest extends BaseGitHubServiceTest {
	
    /** The service. */
	private OAuthService service;
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.BaseFacebookGraphApiTestCase#setUp()
	 */
	public void setUp() throws Exception {
		super.setUp();
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test consumer key."), TestConstants.TEST_CLIENT_ID);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test consumer secret."), TestConstants.TEST_CLIENT_SECRET);
		service = factory.createOAuthService(TestConstants.TEST_CLIENT_ID, TestConstants.TEST_CLIENT_SECRET);
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.BaseFacebookGraphApiTestCase#tearDown()
	 */
	public void tearDown() throws Exception {
		super.tearDown();
		service = null;
	}

	/**
	 * Test get authorization url.
	 */
	public void testGetAuthorizationUrl() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test callback URL."), TestConstants.TEST_CALLBACK_URL);
		String authorizationUrl = service.getAuthorizationUrl(TestConstants.TEST_CALLBACK_URL);
		assertNotNullOrEmpty("Authorization URL should not be null.", authorizationUrl);
		try {
            URL               url     = new URL(authorizationUrl);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
			
			if (request.getResponseCode() != HttpURLConnection.HTTP_OK) {
				fail(convertStreamToString(request.getErrorStream()));
			}
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test get authorization url set.
	 */
	public void testGetAuthorizationUrlSet() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test callback URL."), TestConstants.TEST_CALLBACK_URL);
		String authorizationUrl = service.getAuthorizationUrl(TestConstants.TEST_CALLBACK_URL, EnumSet.of(Permission.USER, Permission.REPOSITORY));
		assertNotNullOrEmpty("Authorization URL should not be null.", authorizationUrl);
		try {
            URL               url     = new URL(authorizationUrl);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
			
			if (request.getResponseCode() != HttpURLConnection.HTTP_OK) {
				fail(convertStreamToString(request.getErrorStream()));
			}
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	/**
	 * Test get access token.
	 */
	public void testGetAccessToken() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test callback URL."), TestConstants.TEST_CALLBACK_URL);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test code."), TestConstants.TEST_CODE);
		String accessToken = service.getAccessToken(TestConstants.TEST_CALLBACK_URL, TestConstants.TEST_CODE);
		assertNotNullOrEmpty("Access token should not be null.", accessToken);
	}
}
