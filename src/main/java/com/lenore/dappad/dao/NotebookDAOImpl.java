package com.lenore.dappad.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lenore.dappad.domain.Notebook;

@Repository
public class NotebookDAOImpl implements NotebookDAO {

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
		Notebook notebook = (Notebook) sessionFactory.getCurrentSession().get(Notebook.class,
				id);
		return notebook;
	}
	
	
	public void editNotebook(Integer id) {
		Notebook notebook = loadNotebook(id);
		System.out.println(notebook.getName());
	}

	@Override
	public Notebook getDefault() {
		return loadNotebook(1);
	}

}
