package com.softwarfair.mockbasics;
import java.util.Set;

/**
 * @author iparraga
 *
 */
public class ReportMaker {
	private UserDao userDao;
	
	public ReportMaker(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public String calculateReport() {
		String report = null;
						
		Set<User> users = userDao.getUsers();
		// report logic that possibly iterates
		// over all the users and aggregates data
		
		return report;
	}
}
