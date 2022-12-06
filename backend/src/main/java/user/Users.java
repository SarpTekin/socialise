package user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="users")
@Data

public class Users {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String username;
	
	private String displayName;
	
	private String password;
	

}
