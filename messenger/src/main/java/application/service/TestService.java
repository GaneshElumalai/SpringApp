package application.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Test")
public class TestService {
	
	@GetMapping("/greet")
	public String greet(){
		return "Hello World !";
	}
}
