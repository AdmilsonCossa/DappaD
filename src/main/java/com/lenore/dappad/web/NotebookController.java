package com.lenore.dappad.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lenore.dappad.domain.Note;
import com.lenore.dappad.domain.Notebook;
import com.lenore.dappad.service.NotebookService;


@Controller
public class NotebookController {
	
	@Autowired
	private NotebookService notebookService;

	// Pages to open
	
	@RequestMapping("/nb-{action}/{notebookId}")
	public ModelAndView action(@PathVariable("notebookId") Integer notebookId, @PathVariable("action") String action) {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("notebook/" + action + "Notebook");
		mav.addObject("notebook", notebookService.loadNotebook(notebookId));

		return mav;
	}
	
	@RequestMapping("/nb-load/{notebookId}")
	public ModelAndView load(@PathVariable("notebookId") Integer notebookId) {

		ModelAndView mav = new ModelAndView();
		Notebook notebook = notebookService.loadNotebookWithNotes(notebookId);
		List<Note> notes = notebook.getNotes();

		mav.setViewName("notebook/loadNotebook");
		mav.addObject("notebook", notebook);
		mav.addObject("noteList", notes);

		return mav;
	}
	
	
	@RequestMapping("/listNotebooks")
	public ModelAndView listNotebook() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("notebook/allNotebooks");
		mav.addObject("notebookList", notebookService.listNotebook());

		return mav;
	}
	

}
