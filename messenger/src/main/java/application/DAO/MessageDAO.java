package application.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import application.entity.Message;
import application.utility.ApplicationConnectionProvider;

public class MessageDAO {
	
	public List<Message> getMessage() throws Exception{
		List<Message> messageList= new ArrayList<Message>();
		Session appSession=null;
		try{
			appSession= ApplicationConnectionProvider.getApplicationConnectionProvider().getAppDBConnection();
			Query<Message> getQuery;
			getQuery= appSession.createQuery("From Message") ;
			messageList = getQuery.list();
		}catch(Exception exception){
			System.err.println("Exception in getMessage : "+exception.getLocalizedMessage());
			throw exception;
		}finally{
			appSession.close();
		}
		
		return messageList;
	}
	
	public Message addMessage(Message msg) throws Exception{
		Session appSession = null;
		try {
			appSession= ApplicationConnectionProvider.getApplicationConnectionProvider().getAppDBConnection();
			appSession.getTransaction().begin();
			appSession.save(msg);
			appSession.getTransaction().commit();
		} catch (Exception exception) {
			System.err.println("Exception in getMessage : "+exception.getLocalizedMessage());
			throw exception;
		}
		finally{
			appSession.close();
		}
		return msg;
	}
}
