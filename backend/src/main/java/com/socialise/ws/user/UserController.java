package com.socialise.ws.user;

import org.springframework.web.bind.annotation.RestController;

import com.socialise.ws.shared.GenericResponse;
import com.socialise.ws.error.ApiError;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController

public class UserController {

	@Autowired
	
	UserService userService;
	
	@PostMapping("/api/1.0/users")
	@ResponseStatus(HttpStatus.CREATED)
	
	public  ResponseEntity<?> createUser(@RequestBody User user) {
		String username = user.getUsername();
		if(username == null || username.isEmpty())			
		{
			ApiError error = new ApiError(400, "Validation error", "/api/1.0/users");
			Map<String, String> validationErrors = new HashMap<>();
			validationErrors.put("username", "Username cannot be null");
			error.setValidationErrors(validationErrors);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		}
		userService.save(user);
		return ResponseEntity.ok(new GenericResponse("User created")) ;
		}

}





