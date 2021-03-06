/**
 * 
 */
package com.github.api.v2.services;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.api.v2.schema.Key;
import com.github.api.v2.schema.Repository;
import com.github.api.v2.schema.User;
import com.github.api.v2.services.constant.TestConstants;

/**
 * @author nmukhtar
 *
 */
public class UserServiceTest extends BaseGitHubServiceTest {
	private UserService service;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		service = factory.createUserService();
		service.setAuthentication(authentication);
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		service = null;
	}

	@Test
	public void testAddEmail() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Email."), TestConstants.TEST_EMAIL);
		service.addEmail(TestConstants.TEST_EMAIL);
	}

	@Test
	public void testAddKey() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Key Title."), TestConstants.TEST_KEY_TITLE);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Key."), TestConstants.TEST_KEY);
		service.addKey(TestConstants.TEST_KEY_TITLE, TestConstants.TEST_KEY);
	}

	@Test
	public void testFollowUser() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
		service.followUser(TestConstants.TEST_USER_NAME);
	}

	@Test
	public void testGetCurrentUser() {
		User user = service.getCurrentUser();
		assertNotNull("User cannot be null.", user);
	}

	@Test
	public void testGetEmails() {
		List<String> emails = service.getEmails();
		assertNotNullOrEmpty("Emails cannot be null or empty.", emails);
	}

	@Test
	public void testGetKeys() {
		List<Key> keys = service.getKeys();
		assertNotNullOrEmpty("Keys cannot be null or empty.", keys);
	}

	@Test
	public void testGetUser() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
		User user = service.getUser(TestConstants.TEST_USER_NAME);
		assertNotNull("User cannot be null.", user);
	}

	@Test
	public void testGetUserFollowers() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
		List<String> userFollowers = service.getUserFollowers(TestConstants.TEST_USER_NAME);
		assertNotNullOrEmpty("User followers cannot be null or empty.", userFollowers);
	}

	@Test
	public void testGetUserFollowing() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
		List<String> userFollowing = service.getUserFollowing(TestConstants.TEST_USER_NAME);
		assertNotNullOrEmpty("User followering cannot be null or empty.", userFollowing);
	}

	@Test
	public void testGetWatchedRepositories() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
		List<Repository> repositories = service.getWatchedRepositories(TestConstants.TEST_USER_NAME);
		assertNotNullOrEmpty("Repositories cannot be null or empty.", repositories);
	}

	@Test
	public void testRemoveEmail() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Email."), TestConstants.TEST_EMAIL);
		service.removeEmail(TestConstants.TEST_EMAIL);
	}

	@Test
	public void testRemoveKey() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Key Id."), TestConstants.TEST_KEY_ID);
		service.removeKey(TestConstants.TEST_KEY_ID);
	}

	@Test
	public void testSearchUsersByEmail() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Email."), TestConstants.TEST_EMAIL);
		List<User> users = service.searchUsersByEmail(TestConstants.TEST_EMAIL);
		assertNotNullOrEmpty("Users cannot be null or empty.", users);
	}

	@Test
	public void testSearchUsersByName() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
		List<User> users = service.searchUsersByName(TestConstants.TEST_USER_NAME);
		assertNotNullOrEmpty("Users cannot be null or empty.", users);
	}

	@Test
	public void testUnfollowUser() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
		service.unfollowUser(TestConstants.TEST_USER_NAME);
	}

	@Test
	public void testUpdateUser() {
//		service.updateUser(user);
	}
}
