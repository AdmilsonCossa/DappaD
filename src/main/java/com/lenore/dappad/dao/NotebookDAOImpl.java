package com.lenore.dappad.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lenore.dappad.HomeController;
import com.lenore.dappad.domain.Notebook;

@Repository
public class NotebookDAOImpl implements NotebookDAO {

	private static final Logger logger = Logger.getLogger(HomeController.class.getName());
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addNotebook(Notebook notebook) {
		sessionFactory.getCurrentSession().save(notebook);
	}
	
	public void updateNotebook(Notebook notebook) {
		sessionFactory.getCurrentSession().merge(notebook);
	}

	@SuppressWarnings("unchecked")
	public List<Notebook> listAllNotebooks() {

		return sessionFactory.getCurrentSession().createQuery("from Notebook")
				.list();
	}

	public void removeNotebook(Notebook notebook) {
		if (null != notebook) {
			sessionFactory.getCurrentSession().delete(notebook);
		}
	}

	public Notebook loadNotebook(Integer id) {
		Notebook notebook = (Notebook) sessionFactory.getCurrentSession().get(Notebook.class,id);
    	Hibernate.initialize(notebook.getNotes());
		return notebook;
	}
	
	
	public void editNotebook(Integer id) {
		Notebook notebook = loadNotebook(id);
		logger.info("Notebook for edit: " + notebook.getTitle());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Notebook getDefaultNotebook() {
		List<Notebook> notebooks = sessionFactory.getCurrentSession()
				.createQuery( "from Notebook where isDefault = true" )
		        .list();
		
		if (notebooks.size() > 0) {
			return notebooks.get(0);
		} else {
			logger.warn("Default notebook not found");
			return null;
		}
	}

}
