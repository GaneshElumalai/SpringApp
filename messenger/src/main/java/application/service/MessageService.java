package application.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import application.entity.Message;
import application.entity.User;
import application.exception.ResourceNotFound;
import application.repo.MessageRepo;
import application.repo.UserRepo;

@Service
public class MessageService {
	
	@Autowired
	private MessageRepo messageRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	public Message getMessage(long id){
		return messageRepo.findById(id).filter(msg->msg.getDeleted()=='N').orElseThrow(()->new ResourceNotFound("Message not found",404L,"Message"));
	}

	public List<Message> getMessages() {
		return messageRepo.findAll().stream().filter(msg->msg.getDeleted()=='N').collect(Collectors.toList());
	}

	public Message addMessage(long userId,Message msg) {
		msg.setCreated_date(new Date());
		msg.setUpdated_date(new Date());
		msg.setDeleted('N');
		User usr = userRepo.findById(userId).get();
		msg.setUser(usr);
		messageRepo.save(msg);
		return msg;
	}

	public List<Message> getUserMessages(long userId) {
		return messageRepo.findByUserId(userId).stream().filter(msg->msg.getDeleted()=='N').collect(Collectors.toList());
	}
	
	public void deleteMessage(long msgId) {
//		messageRepo.deleteById(msgId);
		Message msg = messageRepo.findById(msgId).get();
		msg.setDeleted('Y');
		messageRepo.save(msg);
	}
}
