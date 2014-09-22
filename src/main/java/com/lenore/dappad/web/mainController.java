package com.lenore.dappad.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lenore.dappad.service.NoteService;

@Controller
public class mainController {

	@Autowired
	private NoteService noteService;

	@RequestMapping("/")
	public ModelAndView listNote() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		mav.addObject("noteList", noteService.listNote());

		return mav;
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/index")
	public String home() {
		return "redirect:/";
	}

}
