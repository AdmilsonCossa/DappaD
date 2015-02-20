package com.lenore.dappad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lenore.dappad.dao.UserDAO;
import com.lenore.dappad.domain.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
    @Override
    public User getUser(String login) {
        User user = new User();
        user.setUsername(login);
        user.setPassword("7110eda4d09e062aa5e4a390b0a572ac0d2c0220");

        return user;
    }
    
    @Transactional
    public User findUser(Integer id) {
    	return userDAO.findUser(id);
    }
    
    @Transactional
    public User findUserByName(String username) {
    	return userDAO.findByUserName(username);
    }
    
    @Transactional
    public List<User> allUsers() {
    	return userDAO.allUsers();
    }
}
