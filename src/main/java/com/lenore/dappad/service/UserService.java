package com.lenore.dappad.service;

import com.lenore.dappad.domain.UserD;

public interface UserService {
	
	UserD getUser(String login);
	
}
