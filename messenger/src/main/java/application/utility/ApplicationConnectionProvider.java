package application.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ApplicationConnectionProvider {
	
	private static ApplicationConnectionProvider appConProvider =null;
	
	private ApplicationConnectionProvider(){
	}
	
	public synchronized static ApplicationConnectionProvider getApplicationConnectionProvider(){
		
		return appConProvider==null ? appConProvider=new ApplicationConnectionProvider() : appConProvider;
	}
	
	public Session getAppDBConnection() throws Exception{
		Session appSession=null;
		
		try{
			SessionFactory sessionFactory = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory();
			appSession=sessionFactory.openSession();
		}catch(Exception ex){
			System.err.println("Exception in getAppDbConnection : "+ex.getLocalizedMessage());
			throw ex;
		}
		return appSession;
	}
	
}
