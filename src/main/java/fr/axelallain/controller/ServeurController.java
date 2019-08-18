package fr.axelallain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.axelallain.service.EventService;

@Controller
public class ServeurController {
	
	@Autowired
	private EventService eventService;
	
	@GetMapping("/sulfuron")
	public String sulfuron(Model model) {
		
		
		return "sulfuron";
	}
	
	@GetMapping("/auberdine")
	public String auberdine() {
		
		return "auberdine";
	}
	
	@GetMapping("/donjons")
	public String donjons() {
		
		return "donjons";
	}
	
	@GetMapping("/raids")
	public String raids() {
		
		return "raids";
	}
	
	@GetMapping("/batailles")
	public String batailles() {
		
		return "batailles";
	}
	
	@GetMapping("/communautaire")
	public String communautaire() {
		
		return "communautaire";
	}
	
	@GetMapping("/roleplay")
	public String roleplay() {
		
		return "roleplay";
	}

}