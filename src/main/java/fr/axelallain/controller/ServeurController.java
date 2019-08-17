package fr.axelallain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServeurController {
	
	@GetMapping("/sulfuron")
	public String sulfuron(Model model) {
		model.addAttribute("events", attributeValue);
		
		return "sulfuron";
	}
	
	@GetMapping("/auberdine")
	public String auberdine() {
		
		return "auberdine";
	}

}
