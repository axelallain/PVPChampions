package fr.axelallain.dao;

import java.util.List;

import fr.axelallain.entity.Commentaire;

public interface CommentaireDao {
	
	void ajouter(Commentaire commentaire);
	
	List<Commentaire> findAllCommentairesByEventId(Long id);
	
	List<Commentaire> findAllCommentairesByUtilisateurId(Long id);
	
	void delete(Long id);
	
	Commentaire findCommentaireById(Long id);

}