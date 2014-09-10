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
	public String listContacts(Map<String, Object> map) {

		map.put("note", new Note());
		map.put("noteList", noteService.listNote());

		return "note";
	}

	@RequestMapping("/")
	public String home() {
		return "redirect:/index";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("note") Note note,
			BindingResult result) {

		noteService.addNote(note);

		return "redirect:/index";
	}

	@RequestMapping("/delete/{noteId}")
	public String deleteContact(@PathVariable("noteId") Integer noteId) {

		noteService.removeNote(noteId);

		return "redirect:/index";
	}
}
