package com.softwarfair.mockbasics;

public class Report {
	private int activeUsers;
	private int inactiveUsers;
	
	public Report(int activeUsers, int inactiveUsers) {
		super();
		this.activeUsers = activeUsers;
		this.inactiveUsers = inactiveUsers;
	}
	
	public int getActiveUsers() {
		return activeUsers;
	}
	
	public int getInactiveUsers() {
		return inactiveUsers;
	}
}
