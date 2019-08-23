package fr.axelallain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.axelallain.UserPrincipal;
import fr.axelallain.entity.Commentaire;
import fr.axelallain.entity.Event;
import fr.axelallain.entity.Utilisateur;
import fr.axelallain.service.CommentaireService;
import fr.axelallain.service.EventService;
import fr.axelallain.service.ServeurService;
import fr.axelallain.service.UtilisateurService;

@Controller
public class UtilisateurController {
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	@Autowired
	private ServeurService serveurService;
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private CommentaireService commentaireService;
	
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
		model.addAttribute("cuserid", cuser.getId());
		
		return "profil";
	}
	
	@GetMapping("/profil/events/{cuserid}")
	public String profilEvents(@PathVariable Long cuserid, Model model) {
		UserPrincipal cuser = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        cuserid = cuser.getId();
        
        model.addAttribute("events", eventService.findAllEventsByUtilisateurId(cuserid));
		
		return "profilevents";
	}
	
	@DeleteMapping("/profil/events/delete/{id}")
	public String profilEventsDelete(@PathVariable Long id) {
		eventService.delete(id);
		
		UserPrincipal cuser = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		return "redirect:/profil/events/" + cuser.getId();
	}
	
	@GetMapping("/profil/events/modifier/{id}")
	public ModelAndView profilEventsModifier(@PathVariable Long id, Model model) {
		
		UserPrincipal cuser = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long cuserid = cuser.getId();
        
        model.addAttribute("cuserid", cuserid);
        
        Event event = eventService.findEventById(id);
        
        ModelAndView modelAndView = new ModelAndView();
        
        modelAndView.setViewName("modifier");
        modelAndView.addObject("event", event);
        
        return modelAndView;
	}
	
	@GetMapping("/profil/commentaires/{cuserid}")
	public String profilCommentaires(@PathVariable Long cuserid, Model model) {
		UserPrincipal cuser = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        cuserid = cuser.getId();
        
        model.addAttribute("commentaires", commentaireService.findAllCommentairesByUtilisateurId(cuserid));
		
		return "profilcommentaires";
	}
	
	@DeleteMapping("/profil/commentaires/delete/{id}")
	public String profilCommentairesDelete(@PathVariable Long id) {
		commentaireService.delete(id);
		
		UserPrincipal cuser = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		return "redirect:/profil/commentaires/" + cuser.getId();
	}
	
	@GetMapping("/profil/commentaires/modifier/{id}")
	public ModelAndView profilCommentairesModifier(@PathVariable Long id, Model model) {
		
		UserPrincipal cuser = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long cuserid = cuser.getId();
        
        model.addAttribute("cuserid", cuserid);
        
        Commentaire commentaire = commentaireService.findCommentaireById(id);
        
        ModelAndView modelAndView = new ModelAndView();
        
        modelAndView.setViewName("modifiercommentaire");
        modelAndView.addObject("commentaire", commentaire);
        
        return modelAndView;
	}

}