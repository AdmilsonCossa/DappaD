package com.lenore.dappad.dao;

import java.util.List;

import com.lenore.dappad.domain.Note;

public interface NoteDAO {
    public void addNote(Note note);

    public List<Note> listNote();

    public void removeNote(Integer id);

}