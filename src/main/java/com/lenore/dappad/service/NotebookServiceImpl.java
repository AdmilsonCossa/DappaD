package com.lenore.dappad.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lenore.dappad.dao.NotebookDAO;
import com.lenore.dappad.domain.Notebook;

@Service
public class NotebookServiceImpl implements NotebookService{
	
	@Autowired
    private NotebookDAO notebookDAO;

	@Transactional
	public void addNotebook(Notebook notebook) {
		notebookDAO.addNotebook(notebook);
	}
	
	@Transactional
    public void updateNotebook(Notebook notebook) {
		if(notebook.isDefault()) {
			setDefaultNotebook(notebook.getId());
		}
		notebookDAO.updateNotebook(notebook);
	}

	@Transactional
	public List<Notebook> listAllNotebooks() {
		return notebookDAO.listAllNotebooks();
	}

	@Transactional
	public void removeNotebook(Notebook notebook) {
		notebookDAO.removeNotebook(notebook);
	}

	@Transactional
	public Notebook loadNotebook(Integer id) {
		return notebookDAO.loadNotebook(id);
	}
	
	@Transactional
	public void editNotebook(Integer id) {
		notebookDAO.editNotebook(id);
	}
	
	@Transactional
    public Notebook loadNotebookWithNotes(Integer id) {
    	Notebook notebook = notebookDAO.loadNotebook(id);
    	Hibernate.initialize(notebook.getNotes());
    	return notebook;
    }
	
	@Transactional
	public Notebook getDefaultNotebook() {
		return notebookDAO.getDefaultNotebook();
	}
	
	@Transactional
	public void setDefaultNotebook(Integer newDefaultId) {
		Notebook oldDefault = notebookDAO.getDefaultNotebook();
		Notebook newDefault = loadNotebook(newDefaultId);
		newDefault.setDefault(true);
		notebookDAO.updateNotebook(newDefault);
		if (oldDefault != null && oldDefault.getId() != newDefaultId) {
			oldDefault.setDefault(false);
			notebookDAO.updateNotebook(oldDefault);
		}
	}

}
