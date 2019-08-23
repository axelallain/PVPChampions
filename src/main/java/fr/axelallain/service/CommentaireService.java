package fr.axelallain.service;

import java.util.List;

import fr.axelallain.entity.Commentaire;

public interface CommentaireService {
	
	void ajouter(Commentaire commentaire);
	
	List<Commentaire> findAllCommentairesByEventId(Long id);
	
	List<Commentaire> findAllCommentairesByUtilisateurId(Long id);
	
	void delete(Long id);
	
	Commentaire findCommentaireById(Long id);

}
