package com.lenore.dappad.dao;

import java.util.List;

import com.lenore.dappad.domain.Note;

public interface NoteDAO {
    public void addNote(Note note);
    public void updateNote(Note note);

    public List<Note> allNotes();

    public void removeNote(Note note);   
    
    public Note loadNote(Integer id);
    
    public void editNote(Integer id);

}
