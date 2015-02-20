package com.lenore.dappad.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lenore.dappad.domain.User;

@Repository
public class UserDAOImpl implements UserDAO {

	private static final Logger logger = Logger.getLogger(UserDAOImpl.class.getName());
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public User findByUserName(String username) {

		List<User> users = new ArrayList<User>();

		users = sessionFactory.getCurrentSession()
				.createQuery( "from User where username = :username" )
		        .setString( "username", username )
		        .list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}
	
	public User findUser(Integer id) {
		User user = (User) sessionFactory.getCurrentSession().load(User.class,id);
		if (user != null ){ 
			logger.info("Found user: " + user.getUsername() + " : " + user.getId());
		}
		return user;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> allUsers() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

}
