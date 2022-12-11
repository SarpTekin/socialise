package com.socialise.ws.user;

import org.springframework.web.bind.annotation.RestController;

import com.socialise.ws.shared.GenericResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController

public class UserController {

	@Autowired
	
	UserService userService;
	
	@PostMapping("/api/1.0/users")
	@ResponseStatus(HttpStatus.CREATED)
	
	public  GenericResponse createUser(@RequestBody User user) {
		userService.save(user);
		return new GenericResponse("User created");
		}

}





