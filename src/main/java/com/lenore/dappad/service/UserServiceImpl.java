package com.lenore.dappad.service;

import org.springframework.stereotype.Service;

import com.lenore.dappad.domain.Username;

@Service
public class UserServiceImpl implements UserService {
	
    @Override
    public Username getUser(String login) {
        Username user = new Username();
        user.setUsername(login);
        user.setPassword("7110eda4d09e062aa5e4a390b0a572ac0d2c0220");

        return user;
    }
}
