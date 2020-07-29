package fr.axelallain.service;

import java.util.List;

import fr.axelallain.entity.Utilisateur;

public interface UtilisateurService {

	List<Utilisateur> findAllUtilisateurs();
	
	void inscription(Utilisateur utilisateur);
	
	Utilisateur findByEmail(String email);

	Utilisateur findById(Long id);
	
}