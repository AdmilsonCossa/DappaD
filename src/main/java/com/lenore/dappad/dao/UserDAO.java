package com.lenore.dappad.dao;

import com.lenore.dappad.domain.UserD;

public interface UserDAO {
	
	UserD findByUserName(String username);

}
