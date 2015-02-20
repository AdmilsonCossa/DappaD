package com.lenore.dappad.dao;

import java.util.List;

import com.lenore.dappad.domain.Notebook;

public interface NotebookDAO {

	void addNotebook(Notebook notebook);

	void updateNotebook(Notebook notebook);

	List<Notebook> listAllNotebooks();

	void removeNotebook(Notebook notebook);

	Notebook loadNotebook(Integer id);

	void editNotebook(Integer id);

	Notebook getDefaultNotebook();

}
