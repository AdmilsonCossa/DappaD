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
	
	@RequestMapping("/notebook/{notebookId}/{action}")
	public ModelAndView action(@PathVariable("notebookId") Integer notebookId, @PathVariable("action") String action) {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("notebook/" + action + "Notebook");
		mav.addObject("notebook", notebookService.loadNotebook(notebookId));

		return mav;
	}
	
	@RequestMapping("/notebook/{notebookId}")
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
	
	@RequestMapping("/notebook/add")
	public ModelAndView add() {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("notebook/addNotebook");
		mav.addObject("notebook", new Notebook());

		return mav;
	}	
	
	//Actions to perform
	
		@RequestMapping(value = "nb/add", method = RequestMethod.POST)
		public String addNote(@ModelAttribute("notebook") Notebook notebook,
				BindingResult result) {

			notebookService.addNotebook(notebook);

			return "redirect:/listNotebooks";
		}

		@RequestMapping(value = "nb/update", method = RequestMethod.POST)
		public String updateNote(@ModelAttribute("notebook") Notebook notebook,
				BindingResult result) {

			notebookService.updateNotebook(notebook);

			return "redirect:/";
		}

		@RequestMapping("nb/delete")
		public String deleteNote(@ModelAttribute("notebook") Notebook notebook,
				BindingResult result) {

			notebookService.removeNotebook(notebook);

			return "redirect:/";
		}

}
