package com.app.blog.Service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.blog.Entities.User;
import com.app.blog.Exceptions.ResourceNotFoundException;
import com.app.blog.Payloads.UserDto;
import com.app.blog.Service.UserService;
import com.app.blog.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDto createUser(UserDto userDto) {

        // Convert DTO -> Entity
        User user = this.dtoToUser(userDto);

        // Save user in DB
        User savedUser = this.userRepo.save(user);

        // Convert Entity -> DTO
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());
        user.setPassword(userDto.getPassword());

        User updatedUser = this.userRepo.save(user);

        return this.userToDto(updatedUser);
    }


    @Override
    public UserDto getUserById(Integer userId) {
    	User user = this.userRepo.findById(userId)
        		.orElseThrow(()-> new ResourceNotFoundException("user","id",userId));
    	
        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepo.findAll();
        List<UserDto> userDtos = users.stream().map(user ->this.userToDto(user)).collect(Collectors.toList());
        
        return userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {
    	User user = this.userRepo.findById(userId)
        		.orElseThrow(()-> new ResourceNotFoundException("user","id",userId));
    	this.userRepo.delete(user);

    }

    // Convert DTO -> Entity
    public User dtoToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());
        user.setPassword(userDto.getPassword());
        return user;
    }

    // Convert Entity -> DTO
    public UserDto userToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setAbout(user.getAbout());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

}
