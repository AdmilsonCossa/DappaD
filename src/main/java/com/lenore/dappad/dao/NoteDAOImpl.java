package com.lenore.dappad.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lenore.dappad.domain.Note;

@Repository
public class NoteDAOImpl implements NoteDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addNote(Note note) {
		sessionFactory.getCurrentSession().save(note);
	}

	@SuppressWarnings("unchecked")
	public List<Note> listNote() {

		return sessionFactory.getCurrentSession().createQuery("from Note")
				.list();
	}

	public void removeNote(Integer id) {
		Note note = (Note) sessionFactory.getCurrentSession().load(Note.class,
				id);
		if (null != note) {
			sessionFactory.getCurrentSession().delete(note);
		}

	}

}
