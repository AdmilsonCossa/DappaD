package com.lenore.dappad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lenore.dappad.dao.NoteDAO;
import com.lenore.dappad.domain.Note;

@Service
public class NoteServiceImpl implements NoteService{
	
	@Autowired
    private NoteDAO noteDAO;

	@Transactional
	public void addNote(Note note) {
		noteDAO.addNote(note);
	}
	
	@Transactional
    public void updateNote(Note note) {
		noteDAO.updateNote(note);
	}

	@Transactional
	public List<Note> listNote() {
		return noteDAO.listNote();
	}

	@Transactional
	public void removeNote(Note note) {
		noteDAO.removeNote(note);
	}
	
	@Transactional
	public Note loadNote(Integer id) {
		return noteDAO.loadNote(id);
	}
	
	@Transactional
	public void editNote(Integer id) {
		noteDAO.editNote(id);
	}
	

}
