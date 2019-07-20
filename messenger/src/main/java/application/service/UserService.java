package application.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.entity.User;
import application.exception.ResourceNotFound;
import application.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	public List<User> getUsers(){
		return userRepo.findAll();
	}

	public User getUser(long id) {
		return userRepo.findById(id).orElseThrow(()->new ResourceNotFound("User not found !", 404L, "User"));
	}

	public User addUser(User user) {
		user.setCreatedDate(new Date());
		user.setUpdatedDate(new Date());
		return userRepo.save(user);
	}
}
