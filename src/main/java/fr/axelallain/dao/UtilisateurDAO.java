package fr.axelallain.dao;

import java.util.List;

import fr.axelallain.entity.Utilisateur;

public interface UtilisateurDAO {

	List<Utilisateur> findAllUtilisateurs();
	
	void inscription(Utilisateur utilisateur);
	
	Utilisateur findByEmail(String email);

	Utilisateur findById(Long id);
	
}