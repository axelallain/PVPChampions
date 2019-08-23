package fr.axelallain.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.axelallain.entity.Commentaire;

@Repository
public class CommentaireDaoImpl implements CommentaireDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void ajouter(Commentaire commentaire) {
		em.merge(commentaire);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Commentaire> findAllCommentairesByEventId(Long id) {
		Query query = em.createQuery("SELECT e FROM Commentaire e WHERE e.event.id=:id ORDER BY dateParution DESC").setParameter("id", id);
		
		return (List<Commentaire>) query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Commentaire> findAllCommentairesByUtilisateurId(Long id) {
		Query query = em.createQuery("SELECT e FROM Commentaire e WHERE e.utilisateur.id=:id").setParameter("id", id);
		
		return (List<Commentaire>) query.getResultList();
	}
	
	@Override
	public void delete(Long id) {
		em.createQuery("delete from Commentaire e where e.id=:id").setParameter("id", id).executeUpdate();
	}
	
	@Override
	public Commentaire findCommentaireById(Long id) {
		Commentaire commentaire = em.find(Commentaire.class, id);
		
		return commentaire;
	}

}
