package com.softwarfair.mockbasics;

import java.util.Collections;
import java.util.Set;

import org.easymock.EasyMock;
import org.testng.annotations.Test;

public class ReportMakerTest {

	@Test
	public void calculateReport() {
		Set<User> users = Collections.emptySet();
		UserDao userDao = EasyMock.createMock(UserDao.class);
		EasyMock.expect(userDao.getUsers()).andReturn(users);
		EasyMock.replay(userDao);
		
		ReportMaker reportMaker = new ReportMaker(userDao);		
	}
}
