package com.socialise.ws.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="users")
@Data

public class User {
	
	
	@Id
	@GeneratedValue
	
	private String username;
	
	private String displayName;
	
	private String password;
	

}
