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
import com.lenore.dappad.service.NoteService;
import com.lenore.dappad.service.NotebookService;

@Controller
public class NoteController {

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
		System.out.println(mav.getViewName());
		mav.addObject("note", noteService.loadNote(noteId));
		mav.addObject("notebookList", notebookService.listAllNotebooks());
		
		noteService.loadNote(noteId);

		return mav;
	}
	
	@RequestMapping("/note/add")
	public ModelAndView add() {

		ModelAndView mav = new ModelAndView();
		List<Notebook> notebookList = notebookService.listAllNotebooks();
		mav.setViewName("note/addNote");
		mav.addObject("note", new Note());
		mav.addObject("notebookList", notebookList);

		return mav;
	}	
	
	@RequestMapping("/listNotes")
	public ModelAndView listNote() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("note/allNotes");
		mav.addObject("noteList", noteService.listNote());

		return mav;
	}
	
	
	//Actions to perform
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addNote(@ModelAttribute("note") Note note,
			BindingResult result) {

		noteService.addNote(note);

		return "redirect:/";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateNote(@ModelAttribute("note") Note note,
			BindingResult result) {

		noteService.updateNote(note);

		return "redirect:/";
	}

	@RequestMapping("/delete")
	public String deleteNote(@ModelAttribute("note") Note note,
			BindingResult result) {

		noteService.removeNote(note);

		return "redirect:/";
	}

}
