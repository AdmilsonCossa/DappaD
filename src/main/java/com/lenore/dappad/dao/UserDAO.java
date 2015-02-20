package com.lenore.dappad.dao;

import java.util.List;

import com.lenore.dappad.domain.User;

public interface UserDAO {
	
	User findByUserName(String username);

	User findUser(Integer id);
	
	List<User> allUsers();
}
