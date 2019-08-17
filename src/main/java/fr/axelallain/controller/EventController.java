package fr.axelallain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventController {
	
	@GetMapping("/ajouter")
	public String ajouterForm() {
		
		return "ajouter";
	}
	
	@PostMapping("/ajouter")
	public String ajouterSubmit() {
		
		return null;
	}

}
