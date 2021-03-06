package com.lenore.dappad.web;

import java.util.List;

import org.apache.log4j.Logger;
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
import com.lenore.dappad.service.NoteService;
import com.lenore.dappad.service.NotebookService;

@Controller
public class NoteController {

	private static final Logger logger = Logger.getLogger(NoteController.class.getName());
	
	@Autowired
	private NoteService noteService;

	@Autowired
	private NotebookService notebookService;

	@ModelAttribute("notebooks")
	public List<Notebook> notebooks() {
		return notebookService.listAllNotebooks();
	}
	
	// Pages to open
	
	@RequestMapping("/note/{noteId}/{action}")
	public ModelAndView action(@PathVariable("noteId") Integer noteId, @PathVariable("action") String action) {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("note/" + action + "Note");
		logger.info("current action: " + mav.getViewName());
		mav.addObject("note", noteService.loadNote(noteId));
		mav.addObject("notebookList", notebookService.listAllNotebooks());
		
		noteService.loadNote(noteId);

		return mav;
	}
	
	@RequestMapping("/note/add")
	public ModelAndView add() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("note/addNote");
		Note note = new Note();
		Notebook notebook = notebookService.getDefaultNotebook();
		note.setNb(notebook);
		mav.addObject("note", note);

		return mav;
	}	
	
	@RequestMapping("/listNotes")
	public ModelAndView listNote() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("note/allNotes");
		mav.addObject("notes", noteService.allNotes());

		return mav;
	}
	
	//Actions to perform
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addNote(@ModelAttribute("note") Note note,
			BindingResult result) {

		Notebook notebook = notebookService.loadNotebook(note.getNb().getId());
		note.setNb(notebook);
		noteService.addNote(note);

		return "redirect:/";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateNote(@ModelAttribute("note") Note note,
			BindingResult result) {

		Notebook notebook = notebookService.loadNotebook(note.getNb().getId());
		note.setNb(notebook);
		noteService.updateNote(note);

		return "redirect:/";
	}

	@RequestMapping("/delete")
	public String deleteNote(@ModelAttribute("note") Note note,
			BindingResult result) {
		note = noteService.loadNote(note.getId());
		note.setNb(null);
		noteService.updateNote(note);
		noteService.removeNote(note);

		return "redirect:/";
	}

}
