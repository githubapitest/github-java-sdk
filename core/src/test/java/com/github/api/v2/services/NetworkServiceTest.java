package com.github.api.v2.services;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.api.v2.schema.Commit;
import com.github.api.v2.schema.Network;
import com.github.api.v2.services.constant.TestConstants;

public class NetworkServiceTest extends BaseGitHubServiceTest {
	private NetworkService service;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		service = factory.createNetworkService();
		service.setAuthentication(authentication);
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		service = null;
	}

	@Test
	public void testGetNetworkDataStringStringString() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Network Hash."), TestConstants.TEST_NETWORK_HASH);
		List<Commit> commits = service.getNetworkData(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME, TestConstants.TEST_NETWORK_HASH);
		assertNotNullOrEmpty("Commits should not be null or empty.", commits);
	}

	@Test
	public void testGetNetworkDataStringStringStringIntInt() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Network Hash."), TestConstants.TEST_NETWORK_HASH);
		List<Commit> commits = service.getNetworkData(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME, TestConstants.TEST_NETWORK_HASH, 1, 5);
		assertNotNullOrEmpty("Commits should not be null or empty.", commits);
	}

	@Test
	public void testGetNetworkMeta() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
		Network networkMeta = service.getNetworkMeta(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME);
		assertNotNull("Network cannot be null", networkMeta);
	}

}
