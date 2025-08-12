package com.wipro.Thyemeleafdemo.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	@GetMapping("/hello")
	String showWelcome(Model m)
	{
		m.addAttribute("name", "Jayanta");
		return "index";		
	}

}
