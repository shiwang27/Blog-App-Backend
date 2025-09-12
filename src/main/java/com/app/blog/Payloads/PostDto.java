package com.app.blog.Payloads;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
	
	private Integer postId; // Added Post ID
	
	private String title;
	
	private String content;
	
	private String imageName; // Renamed for clarity
	
	private Date addedDate; // Added creation date
	
	private CategoryDto categoryDto;
	
	private UserDto userDto;

}