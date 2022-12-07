package com.socialise.ws.user;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController

public class UserController {

	@Autowired
	
	UserRepository userRepository;
	
	@PostMapping("/api/1.0/users")
	
	public void createUser(@RequestBody User user) {
		userRepository.save(user);
	}

}





