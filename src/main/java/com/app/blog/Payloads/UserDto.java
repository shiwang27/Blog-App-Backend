package com.app.blog.Payloads;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private int id ;
	
	@jakarta.validation.constraints.NotEmpty
	@Size(min = 4, message = "username must be min of 4 characters!!!")
	private String name;
	
	@jakarta.validation.constraints.Email(message = "email address is not valid")
	private String email;
	
	@jakarta.validation.constraints.NotEmpty
	@Size(min =3, max = 10, message = "Password must be of 3 characters and max of 10 characters")
	private String password;
	
	@jakarta.validation.constraints.NotEmpty
	private String about;	
	

}
