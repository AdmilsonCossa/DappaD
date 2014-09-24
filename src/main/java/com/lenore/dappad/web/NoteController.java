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
	
	@RequestMapping("/n-{action}/{noteId}")
	public ModelAndView action(@PathVariable("noteId") Integer noteId, @PathVariable("action") String action) {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("note/" + action + "Note");
		System.out.println(mav.getViewName());
		mav.addObject("note", noteService.loadNote(noteId));
		noteService.loadNote(noteId);

		return mav;
	}
	
	@RequestMapping("/n-create")
	public ModelAndView add() {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("note/addNote");
		mav.addObject("note", new Note());

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
