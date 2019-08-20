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
		
		return "sulfurondonjons";
	}
	
	@GetMapping("/sulfuron/raids")
	public String sulfuronRaids(Model model) {
		Long serveurid = (long) 1;
		String type = "raid";
		
		model.addAttribute("events", eventService.findAllEventsByServeurIdAndType(serveurid, type));
		
		return "sulfuronraids";
	}
	
	@GetMapping("/sulfuron/batailles")
	public String sulfuronBatailles(Model model) {
		Long serveurid = (long) 1;
		String type = "bataille";
		
		model.addAttribute("events", eventService.findAllEventsByServeurIdAndType(serveurid, type));
		
		
		return "sulfuronbatailles";
	}
	
	@GetMapping("/sulfuron/communautaire")
	public String sulfuronCommunautaire(Model model) {
		Long serveurid = (long) 1;
		String type = "communautaire";
		
		model.addAttribute("events", eventService.findAllEventsByServeurIdAndType(serveurid, type));
		
		return "sulfuroncommunautaire";
	}
	
	@GetMapping("/sulfuron/roleplay")
	public String sulfuronRoleplay(Model model) {
		Long serveurid = (long) 1;
		String type = "roleplay";
		
		model.addAttribute("events", eventService.findAllEventsByServeurIdAndType(serveurid, type));
		
		return "sulfuronroleplay";
	}
	
	@GetMapping("/auberdine")
	public String auberdine(Model model) {
		Long serveurid = (long) 2;
		
		model.addAttribute("events", eventService.findAllEventsByServeurId(serveurid));
		
		return "auberdine";
	}
	
	@GetMapping("/auberdine/donjons")
	public String auberdineDonjons(Model model) {
		Long serveurid = (long) 2;
		String type = "donjon";
		
		model.addAttribute("events", eventService.findAllEventsByServeurIdAndType(serveurid, type));
				
		return "auberdinedonjons";
	}
	
	@GetMapping("/auberdine/raids")
	public String auberdineRaids(Model model) {
		Long serveurid = (long) 2;
		String type = "raid";
		
		model.addAttribute("events", eventService.findAllEventsByServeurIdAndType(serveurid, type));
		
		return "auberdineraids";
	}
	
	@GetMapping("/auberdine/batailles")
	public String auberdineBatailles(Model model) {
		Long serveurid = (long) 2;
		String type = "bataille";
		
		model.addAttribute("events", eventService.findAllEventsByServeurIdAndType(serveurid, type));
		
		return "auberdinebatailles";
	}
	
	@GetMapping("/auberdine/communautaire")
	public String auberdineCommunautaire(Model model) {
		Long serveurid = (long) 2;
		String type = "communautaire";
		
		model.addAttribute("events", eventService.findAllEventsByServeurIdAndType(serveurid, type));
		
		return "auberdinecommunautaire";
	}
	
	@GetMapping("/auberdine/roleplay")
	public String auberdineRoleplay(Model model) {
		Long serveurid = (long) 2;
		String type = "roleplay";
		
		model.addAttribute("events", eventService.findAllEventsByServeurIdAndType(serveurid, type));
		
		return "auberdineroleplay";
	}

}