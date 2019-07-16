package application.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.Exception.MessageNotFound;
import application.entity.Message;
import application.repo.MessageRepo;

@RestController
@RequestMapping("/messages")
public class MessageService {
	
	@Autowired
	MessageRepo messageRepo;

	@GetMapping("/{id}")
	public Message getMessage(@PathVariable(value="id") long msgId) throws Exception, MessageNotFound{
		return messageRepo.findById(msgId).orElseThrow(()->new MessageNotFound());
		
//		MessageDAO messageService = new MessageDAO();
//		return messageService.getMessage(msgId);
	}
	
	@GetMapping
	public List<Message> getMessages() throws Exception{
		return messageRepo.findAll();
	}
	
	@PostMapping
	public Message addMessage(@RequestBody Message msg){
		msg.setCreated_date(new Date());
		return messageRepo.save(msg);
	}
	
}
