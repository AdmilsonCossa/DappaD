package com.lenore.dappad.service;

import org.springframework.stereotype.Service;

import com.lenore.dappad.domain.UserD;

@Service
public class UserServiceImpl implements UserService {
	
    @Override
    public UserD getUser(String login) {
        UserD user = new UserD();
        user.setUsername(login);
        user.setPassword("7110eda4d09e062aa5e4a390b0a572ac0d2c0220");

        return user;
    }
}
