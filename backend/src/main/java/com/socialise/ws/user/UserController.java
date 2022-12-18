package com.socialise.ws.user;

import jakarta.validation.Valid;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import com.socialise.ws.shared.GenericResponse;
import com.socialise.ws.error.ApiError;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController

public class UserController {

	@Autowired
	
	UserService userService;
	
	@PostMapping("/api/1.0/users")
	@ResponseStatus(HttpStatus.CREATED)
	
	public  GenericResponse createUser(@Valid @RequestBody User user) {
		userService.save(user);
		return new GenericResponse("User created") ;
		}
		@ExceptionHandler(MethodArgumentNotValidException.class)
		@ResponseStatus(HttpStatus.BAD_REQUEST)
		public ApiError handleValidationException(MethodArgumentNotValidException exception) {
			ApiError error = new ApiError(400, "Validation error", "/api/1.0/users");
			Map<String, String> validationErrors = new HashMap<>();

			for(FieldError fieldError: exception.getBindingResult().getFieldErrors())
			{
				validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			error.setValidationErrors(validationErrors);
			return  error;
		}

}







