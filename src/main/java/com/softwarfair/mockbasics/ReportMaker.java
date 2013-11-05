package com.softwarfair.mockbasics;
import java.util.Set;

/**
 * @author iparraga
 *
 */
public class ReportMaker {
	private final UserDao userDao;

	public ReportMaker(UserDao userDao) {
		this.userDao = userDao;
	}

	public Report calculateReportFromPersistence() {
		Set<User> usersAtPersistence = getUsers();
		return calculateReport(usersAtPersistence);
	}

	private Report calculateReport(Set<User> users) {
		int activeUsersCount = 0;
		int inactiveUsersCount = 0;

		for (User currentUser : users) {
			if (currentUser.isActive()) {
				activeUsersCount++;
			} else {
				inactiveUsersCount++;
			}
		}

		return new Report(activeUsersCount, inactiveUsersCount);
	}

	private Set<User> getUsers() {
		return userDao.getUsers();
	}
}
