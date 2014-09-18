package com.lenore.dappad.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lenore.dappad.domain.Note;
import com.lenore.dappad.service.NoteService;

@Controller
public class NoteController {
	
	@Autowired
	private NoteService noteService;

	@RequestMapping("/index")
	public String listNote(Map<String, Object> map) {

		map.put("note", new Note());
		map.put("noteList", noteService.listNote());

		return "note";
	}

	@RequestMapping("/")
	public String home() {
		return "redirect:/index";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addNote(@ModelAttribute("note") Note note,
			BindingResult result) {

		noteService.addNote(note);

		return "redirect:/index";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateNote(@ModelAttribute("note") Note note,
			BindingResult result) {

		noteService.updateNote(note);

		return "redirect:/index";
	}
	
	
	@RequestMapping("/delete/{noteId}")
	public String deleteNote(@PathVariable("noteId") Integer noteId) {

		noteService.removeNote(noteId);

		return "redirect:/index";
	}
	
	@RequestMapping("/load/{noteId}")
	public String loadNote(@PathVariable("noteId") Integer noteId) {

		noteService.loadNote(noteId);

		return "redirect:/index";
	}
		
	@RequestMapping("/edit/{noteId}")
	public String editNote(@PathVariable("noteId") Integer noteId, Map<String, Object> map) {

		map.put("note", noteService.loadNote(noteId));

		return "edit";
	}
		
}
