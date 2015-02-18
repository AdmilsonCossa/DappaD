package com.lenore.dappad.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lenore.dappad.domain.Note;
import com.lenore.dappad.domain.Notebook;
import com.lenore.dappad.service.NotebookService;


@Controller
public class NotebookController {
	
	@Autowired
	private NotebookService notebookService;

	// Pages to open
	
	@RequestMapping("/nb/{notebookId}/{action}")
	public ModelAndView action(@PathVariable("notebookId") Integer notebookId, @PathVariable("action") String action) {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("nb/" + action + "Notebook");
		mav.addObject("notebook", notebookService.loadNotebook(notebookId));

		return mav;
	}
	
	@RequestMapping("/nb/{notebookId}")
	public ModelAndView load(@PathVariable("notebookId") Integer notebookId) {

		ModelAndView mav = new ModelAndView();
		Notebook notebook = notebookService.loadNotebookWithNotes(notebookId);
		List<Note> notes = notebook.getNotes();

		mav.setViewName("nb/loadNotebook");
		mav.addObject("notebook", notebook);
		mav.addObject("noteList", notes);

		return mav;
	}
	
	@RequestMapping("/nb/{notebookId}/add")
	public ModelAndView addNoteToNb(@PathVariable("notebookId") Integer notebookId) {

		ModelAndView mav = new ModelAndView();
		Notebook notebook = notebookService.loadNotebook(notebookId);

		Note note = new Note();
		note.setNb(notebook);
		mav.setViewName("note/addNote");
		mav.addObject("note", note);

		return mav;
	}
	
	@RequestMapping("/listNotebooks")
	public ModelAndView listNotebook() {
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
		public String addNote(@ModelAttribute("notebook") Notebook notebook,
				BindingResult result) {

			notebookService.addNotebook(notebook);

			return "redirect:/listNotebooks";
		}

		@RequestMapping(value = "/nb/update", method = RequestMethod.POST)
		public String updateNote(@ModelAttribute("notebook") Notebook notebook,
				BindingResult result) {

			notebookService.updateNotebook(notebook);

			return "redirect:/";
		}

		@RequestMapping("/nb/delete")
		public String deleteNote(@ModelAttribute("notebook") Notebook notebook,
				BindingResult result) {

			notebookService.removeNotebook(notebook);

			return "redirect:/";
		}

}
