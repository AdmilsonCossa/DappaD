package com.lenore.dappad.service;

import java.util.List;

import com.lenore.dappad.domain.Notebook;

public interface NotebookService {
	
    void addNotebook(Notebook notebook);

	void updateNotebook(Notebook notebook);

    List<Notebook> listAllNotebooks();

    void removeNotebook(Notebook notebook);
    
    Notebook loadNotebook(Integer id);
    
    Notebook loadNotebookWithNotes(Integer id);
    
    void editNotebook(Integer id);
    
    Notebook getDefaultNotebook();
    
    void setDefaultNotebook(Integer newDefaultId);
}
