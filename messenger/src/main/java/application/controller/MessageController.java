package application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.entity.Message;
import application.service.MessageService;

@RestController
@RequestMapping("/messages")
public class MessageController {
	
	@Autowired
	private MessageService messageService;

	@GetMapping("/{id}")
	public Message getMessage(@PathVariable(value="id") long msgId){
		return messageService.getMessage(msgId);
	}
	
	@GetMapping
	public List<Message> getMessages() throws Exception{
		return messageService.getMessages();
	}
	
	@PostMapping
	public Message addMessage(@RequestBody Message msg){
		return messageService.addMessage(msg);
	}
	
}
