package com.lenore.dappad.dao;

import com.lenore.dappad.domain.Username;

public interface UserDAO {
	
	Username findByUserName(String username);

}
