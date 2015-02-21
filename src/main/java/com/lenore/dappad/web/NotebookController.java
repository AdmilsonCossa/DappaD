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

/**
 * Notebook controller. Functions that are supported:
 * 
 * - new NB:    title, setDefault
 * - load NB:   title, notes, isDefault 
 * - edit NB:   title, setDefault 
 * - delete NB: title, delete with notes, delete just NB. Notes will be without notebook
 * - delete NB: default? - change to some other NB - select form
 * - setDfltNB: set NB as default, reset the previous
 * 
 * @author lenore
 *
 */
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
	
	@RequestMapping("/nb/new")
	public ModelAndView add() {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("nb/newNotebook");
		mav.addObject("notebook", new Notebook());

		return mav;
	}	

	@RequestMapping("/nb/{notebookId}/")
	public ModelAndView loadNotebook(@PathVariable("notebookId") Integer notebookId) {
		
		ModelAndView mav = new ModelAndView();
		
		Notebook notebook = notebookService.loadNotebook(notebookId);
		List<Note> notes = notebook.getNotes();
		
		mav.setViewName("nb/loadNotebook");
		mav.addObject("notebook", notebook);
		mav.addObject("notes", notes);
		
		return mav;
	}
	
	@RequestMapping("/nb/{notebookId}/delete")
	public ModelAndView deleteNotebook(@PathVariable("notebookId") Integer notebookId) {

		ModelAndView mav = new ModelAndView();
		Notebook notebook;
		notebook = notebookService.loadNotebook(notebookId);
		if (notebook.isDefault()) {
			Notebook newDefault = new Notebook();
			mav.addObject("newDefault", newDefault);
//			mav.addObject("isDefault", true);
		} 
		
		mav.setViewName("nb/deleteNotebook");
		mav.addObject("notebook", notebook);
		
		return mav;
	}
	
	@RequestMapping("/nb/{notebookId}/edit")
	public ModelAndView editNotebook(@PathVariable("notebookId") Integer notebookId) {

		ModelAndView mav = new ModelAndView();
		Notebook notebook;
		notebook = notebookService.loadNotebook(notebookId);
		
		mav.setViewName("nb/editNotebook");
		mav.addObject("notebook", notebook);
		
		return mav;
	}

	@RequestMapping("/nb/{notebookId}/add")
	public ModelAndView addNoteNotebook(@PathVariable("notebookId") Integer notebookId) {

		ModelAndView mav = new ModelAndView();
		
		Notebook notebook = notebookService.loadNotebook(notebookId);
		Note note = new Note();

		note.setNb(notebook);
		mav.setViewName("note/addNote");
		mav.addObject("note", note);
		mav.addObject("notebook", notebook);

		return mav;
	}
	
	
	
	
	@RequestMapping("/listNotebooks")
	public ModelAndView listNotebooks() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("nb/allNotebooks");
		mav.addObject("notebookList", notebookService.listAllNotebooks());

		return mav;
	}
	

	
	//Actions to perform
	
	@RequestMapping(value = "/nb/new", method = RequestMethod.POST)
	public String addNotebook(@ModelAttribute("notebook") Notebook notebook,
			BindingResult result) {

		notebookService.addNotebook(notebook);

		return "redirect:/listNotebooks";
	}

	@RequestMapping(value = "/nb/update", method = RequestMethod.POST)
	public String updateNotebook(@ModelAttribute("notebook") Notebook notebook,
			BindingResult result) {

		notebookService.updateNotebook(notebook);

		return "redirect:/nb/" + notebook.getId() + "/";
	}

	@RequestMapping(value = "/nb/delete", method = RequestMethod.POST)
	public String deleteNoteBook(@ModelAttribute("notebook") Notebook notebook, 
			@RequestParam("submit") String data,
			@RequestParam("newDefaultId") Integer newDefaultId,
			BindingResult result) {
		if (newDefaultId != null) {
			notebookService.setDefaultNotebook(newDefaultId);
		}
		notebook = notebookService.loadNotebook(notebook.getId());
		if (data.compareTo("recursive") != 0) {
			List<Note> notes = notebook.getNotes();
			for (Note note : notes) {
				note.setNb(null);
				noteService.updateNote(note);
			}
			notebook.setNotes(null);
		}
		notebookService.removeNotebook(notebook);

		return "redirect:/listNotebooks";
	}
	
	@RequestMapping(value = "/nb/setDflt", method = RequestMethod.POST)
	public String setDefaultNotebook(@ModelAttribute("notebook") Notebook notebook) {
		notebookService.setDefaultNotebook(notebook.getId());
		return "redirect:/nb/" + notebook.getId() + "/";
	}

}
