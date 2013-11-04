import java.util.Set;

/**
 * @author iparraga
 *
 */
public class ReportMaker {
	private UserDao userDao;
	
	public String calculateReport() {
		String report = null;
						
		Set<User> users = getUserDao().getUsers();
		// report logic that possibly iterates
		// over all the users and aggregates data
		
		return report;
	}
	
	protected UserDao getUserDao() {
		return userDao;
	}
}
