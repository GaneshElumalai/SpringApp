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
import application.entity.User;
import application.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User> getUsers(){
		return userService.getUsers();
	}
	@GetMapping("/{userId}")
	public User getUser(@PathVariable("userId") long userId) {
		return userService.getUser(userId);
	}
	@PostMapping
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
}
