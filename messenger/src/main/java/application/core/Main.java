package application.core;

import application.DAO.MessageDAO;
import application.entity.Message;

public class Main {
	public static void main(String[] args) throws Exception {
		try{
			MessageDAO messageService = new MessageDAO();
//			Message msg = new Message("Hi from Main", "Java 1.8");
//			messageService.addMessage(msg);
			System.out.println(messageService.getMessage());
			
		}
		catch (Exception e) {
			System.out.println("Exception unhandled : "+e.getLocalizedMessage());
		}
	}
}
