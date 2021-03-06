package com.github.api.v2.services;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.api.v2.schema.Comment;
import com.github.api.v2.schema.Issue;
import com.github.api.v2.services.constant.TestConstants;

public class IssueServiceTest extends BaseGitHubServiceTest {
	private IssueService service;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		service = factory.createIssueService();
		service.setAuthentication(authentication);
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		service = null;
	}

	@Test
	public void testAddComment() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Issue No."), TestConstants.TEST_ISSUE_NUMBER);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Comment."), TestConstants.TEST_ISSUE_COMMENT);
		service.addComment(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME, Integer.parseInt(TestConstants.TEST_ISSUE_NUMBER), TestConstants.TEST_ISSUE_COMMENT);
	}

	@Test
	public void testAddLabel() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Issue No."), TestConstants.TEST_ISSUE_NUMBER);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Label."), TestConstants.TEST_ISSUE_LABEL);
		service.addLabel(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME, Integer.parseInt(TestConstants.TEST_ISSUE_NUMBER), TestConstants.TEST_ISSUE_LABEL);
	}

	@Test
	public void testCloseIssue() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Issue No."), TestConstants.TEST_ISSUE_NUMBER);
		service.closeIssue(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME, Integer.parseInt(TestConstants.TEST_ISSUE_NUMBER));
	}

	@Test
	public void testCreateIssue() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Issue Title."), TestConstants.TEST_ISSUE_TITLE);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Issue Body."), TestConstants.TEST_ISSUE_BODY);
		service.createIssue(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME, TestConstants.TEST_ISSUE_TITLE, TestConstants.TEST_ISSUE_BODY);
	}

	@Test
	public void testGetIssue() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Issue No."), TestConstants.TEST_ISSUE_NUMBER);
		Issue issue = service.getIssue(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME, Integer.parseInt(TestConstants.TEST_ISSUE_NUMBER));
		assertNotNull("Issue cannot be null.", issue);
	}

	@Test
	public void testGetIssueComments() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Issue No."), TestConstants.TEST_ISSUE_NUMBER);
		List<Comment> issueComments = service.getIssueComments(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME, Integer.parseInt(TestConstants.TEST_ISSUE_NUMBER));
		assertNotNullOrEmpty("Issue comments cannot be null or empty.", issueComments);
	}

	@Test
	public void testGetIssueLabels() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
		List<String> issueLabels = service.getIssueLabels(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME);
		assertNotNullOrEmpty("Issue labels should not be null or empty.", issueLabels);
	}

	@Test
	public void testGetIssues() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
		List<Issue> issues = service.getIssues(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME, Issue.State.OPEN);
		assertNotNullOrEmpty("Issues cannot be null or empty.", issues);
	}

	@Test
	public void testRemoveLabel() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Issue No."), TestConstants.TEST_ISSUE_NUMBER);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Label."), TestConstants.TEST_ISSUE_LABEL);
		List<String> labels = service.removeLabel(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME, Integer.parseInt(TestConstants.TEST_ISSUE_NUMBER), TestConstants.TEST_ISSUE_LABEL);
		assertFalse("Label should not be in the list.", labels.contains(TestConstants.TEST_ISSUE_LABEL));
	}

	@Test
	public void testReopenIssue() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Issue No."), TestConstants.TEST_ISSUE_NUMBER);
		service.reopenIssue(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME, Integer.parseInt(TestConstants.TEST_ISSUE_NUMBER));
	}

	@Test
	public void testSearchIssues() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Query."), TestConstants.TEST_QUERY);
		List<Issue> issues = service.searchIssues(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME, Issue.State.OPEN, TestConstants.TEST_QUERY);
		assertNotNullOrEmpty("Issues cannot be null or empty.", issues);
	}

	@Test
	public void testUpdateIssue() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Username."), TestConstants.TEST_USER_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Repository."), TestConstants.TEST_REPOSITORY_NAME);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Issue No."), TestConstants.TEST_ISSUE_NUMBER);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Issue Title."), TestConstants.TEST_ISSUE_TITLE);
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Issue Body."), TestConstants.TEST_ISSUE_BODY);
		service.updateIssue(TestConstants.TEST_USER_NAME, TestConstants.TEST_REPOSITORY_NAME, Integer.parseInt(TestConstants.TEST_ISSUE_NUMBER), TestConstants.TEST_ISSUE_TITLE, TestConstants.TEST_ISSUE_BODY);
	}
}
