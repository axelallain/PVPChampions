package fr.axelallain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UtilisateurController {
	
	@GetMapping("/connexion")
	public String connexionForm() {
		
		return "connexion";
	}
	
	@PostMapping("/connexion")
	public String connexionSubmit() {
		
		return "redirect:/";
	}
	
	@GetMapping("/inscription")
	public String inscriptionForm() {
		
		return "inscription";
	}
	
	@PostMapping("/inscription")
	public String inscriptionSubmit() {
		
		return "redirect:/";
	}

}