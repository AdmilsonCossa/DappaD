package com.lenore.dappad.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lenore.dappad.domain.Note;
import com.lenore.dappad.service.NoteService;

@Controller
public class NoteController {

	@Autowired
	private NoteService noteService;

	// Pages to open
	
	@RequestMapping("/note/{noteId}")
	public String loadNote(@PathVariable("noteId") Integer noteId) {

		noteService.loadNote(noteId);

		return "loadNote";
	}
	
	@RequestMapping("/add")
	public ModelAndView add() {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("addNote");
		mav.addObject("note", new Note());

		return mav;
	}	
	
	@RequestMapping("/edit/{noteId}")
	public ModelAndView editNote(@PathVariable("noteId") Integer noteId) {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("editNote");
		mav.addObject("note", noteService.loadNote(noteId));
		return mav;

	}	
	
	
	//Actions to perform
	
	@RequestMapping(value = "/addNote", method = RequestMethod.POST)
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

	@RequestMapping("/delete/{noteId}")
	public String deleteNote(@PathVariable("noteId") Integer noteId) {

		noteService.removeNote(noteId);

		return "redirect:/";
	}

}
