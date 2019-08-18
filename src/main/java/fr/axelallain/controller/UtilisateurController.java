package fr.axelallain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import fr.axelallain.UserPrincipal;
import fr.axelallain.entity.Utilisateur;
import fr.axelallain.service.ServeurService;
import fr.axelallain.service.UtilisateurService;

@Controller
public class UtilisateurController {
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	@Autowired
	private ServeurService serveurService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/login")
	public String loginForm() {
		
		return "login";
	}
	
	@GetMapping("/inscription")
	public String inscriptionForm(Model model) {
		model.addAttribute("utilisateur", new Utilisateur());
		model.addAttribute("serveurs", serveurService.findAllServeurs());
		
		return "inscription";
	}
	
	@PostMapping("/inscription")
	public String inscriptionSubmit(Utilisateur utilisateur) {
		utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
		utilisateurService.inscription(utilisateur);
		
		return "redirect:/";
	}
	
	@GetMapping("/profil")
	public String profilForm(Model model) {	
		UserPrincipal cuser = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		model.addAttribute("cuser", cuser);
		
		return "profil";
	}

}