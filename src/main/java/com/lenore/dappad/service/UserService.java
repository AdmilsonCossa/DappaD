package com.lenore.dappad.service;

import java.util.List;

import com.lenore.dappad.domain.User;

public interface UserService {
	
	User getUser(String login);
	
	User findUser(Integer id);
	
	User findUserByName(String username);
	
	List<User> allUsers();
	
}
