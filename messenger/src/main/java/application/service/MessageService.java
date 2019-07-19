package application.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.entity.Message;
import application.exception.MessageNotFound;
import application.repo.MessageRepo;

@Service
public class MessageService {
	
	@Autowired
	private MessageRepo messageRepo;
	
	public Message getMessage(long id){
		return messageRepo.findById(id).orElseThrow(()->new MessageNotFound());
	}

	public List<Message> getMessages() {
		return messageRepo.findAll();
	}

	public Message addMessage(Message msg) {
		msg.setCreated_date(new Date());
		messageRepo.save(msg);
		return msg;
	}

}
