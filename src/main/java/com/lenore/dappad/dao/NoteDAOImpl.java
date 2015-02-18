package com.lenore.dappad.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lenore.dappad.domain.Note;
import com.lenore.dappad.domain.Notebook;

@Repository
public class NoteDAOImpl implements NoteDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addNote(Note note) {
		if (note.getNb() == null){
			Notebook notebook = (Notebook) sessionFactory.getCurrentSession().load(Notebook.class,
					1);
			note.setNb(notebook);
		}
		sessionFactory.getCurrentSession().save(note);
	}
	
	public void updateNote(Note note) {
		sessionFactory.getCurrentSession().merge(note);
	}

	@SuppressWarnings("unchecked")
	public List<Note> listNote() {

		return sessionFactory.getCurrentSession().createQuery("from Note")
				.list();
	}

	public void removeNote(Note note) {
		if (null != note) {
			sessionFactory.getCurrentSession().delete(note);
		}

	}
	
	public Note loadNote(Integer id) {
		Note note = (Note) sessionFactory.getCurrentSession().load(Note.class,
				id);
		System.out.println(note.getTitle() + " : " + note.getText() + " : " + note.getNb());
		return note;
	}
	
	
	public void editNote(Integer id) {
		Note note = loadNote(id);
		System.out.println(note.getTitle() + " : " + note.getText());

	}

}
