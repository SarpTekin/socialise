package com.socialise.ws;

import com.socialise.ws.user.User;
import com.socialise.ws.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EntityScan(basePackages = "com.socialise.ws.user") 
public class WsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsApplication.class, args);
	}
	@Bean
	CommandLineRunner createInitialUsers(UserService userService) {
		return  (args)  -> {
				User user = new User();
				user.setUsername("user1");
				user.setDisplayName("display1");
				user.setPassword("P4ssword");
				userService.save(user);

			};
		};
	}


