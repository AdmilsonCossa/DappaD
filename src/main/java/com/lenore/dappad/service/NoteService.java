package com.lenore.dappad.service;

import java.util.List;

import com.lenore.dappad.domain.Note;

public interface NoteService {
    public void addNote(Note note);

	public void updateNote(Note note);

    public List<Note> listNote();

    public void removeNote(Integer id);
    public Note loadNote(Integer id);
    public void editNote(Integer id);
}
