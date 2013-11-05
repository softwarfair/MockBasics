package com.softwarfair.mockbasics;

import static org.testng.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.easymock.EasyMock;
import org.testng.annotations.Test;

public class ReportMakerTest {
	@Test
	public void calculateReport_noUsers() {
		int expectedActiveUsers = 0;
		int expectedInactiveUsers = 0;
		UserDao userDao = createMockUserDao(expectedActiveUsers, expectedInactiveUsers);

		ReportMaker reportMaker = new ReportMaker(userDao);
		Report actualReport = reportMaker.calculateReportFromPersistence();

		assertEquals(actualReport.getActiveUsers(), expectedActiveUsers);
		assertEquals(actualReport.getInactiveUsers(), expectedInactiveUsers);
	}

	@Test
	public void calculateReport_someUsers() {
		int expectedActiveUsers = 1;
		int expectedInactiveUsers = 3;
		UserDao userDao = createMockUserDao(expectedActiveUsers, expectedInactiveUsers);

		ReportMaker reportMaker = new ReportMaker(userDao);
		Report actualReport = reportMaker.calculateReportFromPersistence();

		assertEquals(actualReport.getActiveUsers(), expectedActiveUsers);
		assertEquals(actualReport.getInactiveUsers(), expectedInactiveUsers);
	}

	private UserDao createMockUserDao(int activeUsersCount, int inactiveUsersCount) {
		Set<User> usersToReturnByDao =
				createUsersToReturnByDao(activeUsersCount, inactiveUsersCount);

		UserDao userDao = EasyMock.createMock(UserDao.class);
		EasyMock.expect(userDao.getUsers()).andReturn(usersToReturnByDao);
		EasyMock.replay(userDao);
		return userDao;
	}

	private Set<User> createUsersToReturnByDao(
			int activeUsersCount, int inactiveUsersCount) {

		Set<User> usersToReturnByDao = new HashSet<>();

		addUsersToSet(inactiveUsersCount, usersToReturnByDao, false);
		addUsersToSet(activeUsersCount, usersToReturnByDao, true);

		return usersToReturnByDao;
	}

	private void addUsersToSet(int count, Set<User> users, boolean status) {
		for (int i = 0; i < count; i++) {
			users.add(new User(status));
		}
	}
}
