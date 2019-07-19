package application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.entity.Message;
import application.entity.User;
import application.repo.MessageRepo;
import application.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private MessageRepo messageRepo;
	
	public List<User> getUsers(){
		return userRepo.findAll();
	}

	public List<Message> getUserMessages(long userId) {
		return messageRepo.findByUserId(userId);
	}
}
