package com.lenore.dappad.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lenore.dappad.domain.Username;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public Username findByUserName(String username) {

		List<Username> users = new ArrayList<Username>();

		users = sessionFactory.getCurrentSession()
				.createQuery("from User where username=?")
				.setParameter(0, username).list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}

}
