package fr.axelallain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import fr.axelallain.entity.Utilisateur;
import fr.axelallain.service.UtilisateurService;

@Controller
public class UtilisateurController {
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/connexion")
	public String connexionForm() {
		
		return "connexion";
	}
	
	@PostMapping("/connexion")
	public String connexionSubmit() {
		
		return "redirect:/";
	}
	
	@GetMapping("/inscription")
	public String inscriptionForm(Model model) {
		model.addAttribute("utilisateur", new Utilisateur());
		
		return "inscription";
	}
	
	@PostMapping("/inscription")
	public String inscriptionSubmit(Utilisateur utilisateur) {
		utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
		utilisateurService.inscription(utilisateur);
		
		return "redirect:/";
	}

}