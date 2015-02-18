package com.lenore.dappad.service;

import java.util.List;

import com.lenore.dappad.domain.Notebook;

public interface NotebookService {
    public void addNotebook(Notebook notebook);

	public void updateNotebook(Notebook notebook);

    public List<Notebook> listAllNotebooks();

    public void removeNotebook(Notebook notebook);
    public Notebook loadNotebook(Integer id);
    public Notebook loadNotebookWithNotes(Integer id);
    public void editNotebook(Integer id);
}
