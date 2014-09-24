package com.lenore.dappad.dao;

import java.util.List;

import com.lenore.dappad.domain.Notebook;

public interface NotebookDAO {
    public void addNotebook(Notebook notebook);
    public void updateNotebook(Notebook notebook);

    public List<Notebook> listNotebook();

    public void removeNotebook(Notebook notebook);   
    
    public Notebook loadNotebook(Integer id);
    
    public void editNotebook(Integer id);
    
    public Notebook getDefault();

}
