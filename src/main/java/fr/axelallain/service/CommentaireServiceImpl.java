package fr.axelallain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.axelallain.dao.CommentaireDao;
import fr.axelallain.entity.Commentaire;

@Service
@Transactional
public class CommentaireServiceImpl implements CommentaireService {
	
	@Autowired
	private CommentaireDao commentaireDao;
	
	@Override
	public void ajouter(Commentaire commentaire) {
		commentaireDao.ajouter(commentaire);
	}
	
	@Override
	public List<Commentaire> findAllCommentairesByEventId(Long id) {
		return commentaireDao.findAllCommentairesByEventId(id);
	}
	
	@Override
	public List<Commentaire> findAllCommentairesByUtilisateurId(Long id) {
		return commentaireDao.findAllCommentairesByUtilisateurId(id);
	}
	
	@Override
	public void delete(Long id) {
		commentaireDao.delete(id);
	}
	
	@Override
	public Commentaire findCommentaireById(Long id) {
		return commentaireDao.findCommentaireById(id);
	}
	
}