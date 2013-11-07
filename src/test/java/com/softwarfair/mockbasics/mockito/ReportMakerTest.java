package com.softwarfair.mockbasics.mockito;


import com.softwarfair.mockbasics.Report;
import com.softwarfair.mockbasics.ReportMaker;
import com.softwarfair.mockbasics.User;
import com.softwarfair.mockbasics.UserDao;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.assertEquals;

/**
 * Same test as before but this time with Mockito instead of EasyMock
 */
public class ReportMakerTest {
    @Test
    public void calculateReport_noUsers() {
        UserDao userDao = Mockito.mock(UserDao.class);
        Mockito.when(userDao.getUsers()).thenReturn(Collections.<User>emptySet());

        ReportMaker reportMaker = new ReportMaker(userDao);
        Report actualReport = reportMaker.calculateReportFromPersistence();

        assertEquals(actualReport.getActiveUsers(), 0);
        assertEquals(actualReport.getInactiveUsers(), 0);
    }

    @Test
    public void calculateReport_someUsers() {
        int expectedActiveUsers = 1;
        int expectedInactiveUsers = 3;

        UserDao userDao = Mockito.mock(UserDao.class);
        Mockito.when(userDao.getUsers()).thenReturn(createUsersToReturnByDao(expectedActiveUsers,
                expectedInactiveUsers));

        ReportMaker reportMaker = new ReportMaker(userDao);
        Report actualReport = reportMaker.calculateReportFromPersistence();

        assertEquals(actualReport.getActiveUsers(), expectedActiveUsers);
        assertEquals(actualReport.getInactiveUsers(), expectedInactiveUsers);
    }

    @Test
    public void calculateReport_checkCollaborationOnDao() {
        UserDao userDao = Mockito.mock(UserDao.class);
        Mockito.when(userDao.getUsers()).thenReturn(Collections.<User>emptySet());

        ReportMaker reportMaker = new ReportMaker(userDao);
        reportMaker.calculateReportFromPersistence();

        Mockito.verify(userDao).getUsers();
    }


    private Set<User> createUsersToReturnByDao(int activeUsersCount,
                                               int inactiveUsersCount) {
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
