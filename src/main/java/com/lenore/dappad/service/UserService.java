package com.lenore.dappad.service;

import com.lenore.dappad.domain.Username;

public interface UserService {
	
	Username getUser(String login);
	
}
