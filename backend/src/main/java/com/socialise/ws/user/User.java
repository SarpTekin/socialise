package com.socialise.ws.user;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue
	private long id;
	@NotNull
	@Size(min = 4, max = 20)
	@UniqueUsername
	private String username;
	@NotNull
	@Size(min = 4, max = 20)
	private String displayName;
	@NotNull
	@Size(min = 8, max = 20)
	//@Pattern(regexp = "^(?=.[a-z])(?=.[A-Z])(?=.\\d).$")
	private String password;
	
}
