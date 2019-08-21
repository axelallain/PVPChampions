package fr.axelallain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fr.axelallain.UserPrincipal;
import fr.axelallain.entity.Event;
import fr.axelallain.service.EventService;

@Controller
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@GetMapping("/ajouter")
	public String ajouterForm(Model model) {
		model.addAttribute("event", new Event());
		
		UserPrincipal cuser = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Long cuserid = cuser.getId();
		model.addAttribute("cuserid", cuserid);
		
		return "ajouter";
	}
	
	@PostMapping("/ajouter")
	public String ajouterSubmit(Event event) {
		eventService.ajouter(event);
		
		return "redirect:/";
	}
	
	@GetMapping("/event/{id}")
	public String ficheEvent(@PathVariable Long id, Model model) {
		model.addAttribute("event", eventService.findEventById(id));
		
		return "event";
	}
	
}