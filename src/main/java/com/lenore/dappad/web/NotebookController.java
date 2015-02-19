package com.lenore.dappad.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lenore.dappad.domain.Note;
import com.lenore.dappad.domain.Notebook;
import com.lenore.dappad.service.NoteService;
import com.lenore.dappad.service.NotebookService;


@Controller
public class NotebookController {
	
	@Autowired
	private NoteService noteService;
	
	@Autowired
	private NotebookService notebookService;

	@ModelAttribute("notebooks")
	public List<Notebook> notebooks() {
		return notebookService.listAllNotebooks();
	}
	// Pages to open
	
	@RequestMapping("/nb/{notebookId}/{action}")
	public ModelAndView action(@PathVariable("notebookId") Integer notebookId, @PathVariable("action") String action) {

		ModelAndView mav = new ModelAndView();
		Notebook notebook;
		if (action.compareTo("load") == 0) {
			notebook = notebookService.loadNotebookWithNotes(notebookId);
			List<Note> notes = notebook.getNotes();
			mav.addObject("notes", notes);
		} else {
			notebook = notebookService.loadNotebook(notebookId);
		}
		mav.setViewName("nb/" + action + "Notebook");
		mav.addObject("notebook", notebook);
		
		if (action.compareTo("add") == 0) {
			Note note = new Note();
			note.setNb(notebook);
			mav.setViewName("note/addNote");
			mav.addObject("note", note);
		}

		return mav;
	}
	
	@RequestMapping("/listNotebooks")
	public ModelAndView listNotebooks() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("nb/allNotebooks");
		mav.addObject("notebookList", notebookService.listAllNotebooks());

		return mav;
	}
	
	@RequestMapping("/nb/add")
	public ModelAndView add() {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("nb/addNotebook");
		mav.addObject("notebook", new Notebook());

		return mav;
	}	
	
	//Actions to perform
	
		@RequestMapping(value = "/nb/add", method = RequestMethod.POST)
		public String addNotebook(@ModelAttribute("notebook") Notebook notebook,
				BindingResult result) {

			notebookService.addNotebook(notebook);

			return "redirect:/listNotebooks";
		}

		@RequestMapping(value = "/nb/update", method = RequestMethod.POST)
		public String updateNotebook(@ModelAttribute("notebook") Notebook notebook,
				BindingResult result) {

			notebookService.updateNotebook(notebook);

			return "redirect:/nb/" + notebook.getId() + "/load";
		}

		@RequestMapping("/nb/delete")
		public String deleteNoteBook(@ModelAttribute("notebook") Notebook notebook, 
				@RequestParam("submit") String data,
				BindingResult result) {
			if (data.compareTo("recursive") != 0) {
				List<Note> notes = notebookService.loadNotebookWithNotes(notebook.getId()).getNotes();
				for (Note note : notes) {
					note.setNb(null);
					noteService.updateNote(note);
				}
			} else {
				notebook = notebookService.loadNotebookWithNotes(notebook.getId());
			}
			notebookService.removeNotebook(notebook);

			return "redirect:/listNotebooks";
		}

}
