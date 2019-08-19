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
		Long serveurid = (long) 1;
		
		model.addAttribute("events", eventService.findAllEventsByServeurId(serveurid));
		
		return "sulfuron";
	}
	
	@GetMapping("/sulfuron/donjons")
	public String sulfuronDonjons(Model model) {
		Long serveurid = (long) 1;
		String type = "donjon";
		
		model.addAttribute("events", eventService.findAllEventsByServeurIdAndType(serveurid, type));
		
		return "donjons";
	}
	
	@GetMapping("/auberdine")
	public String auberdine(Model model) {
		Long serveurid = (long) 2;
		
		model.addAttribute("events", eventService.findAllEventsByServeurId(serveurid));
		
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