package fr.axelallain.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.axelallain.entity.Commentaire;
import org.springframework.stereotype.Repository;

import fr.axelallain.entity.Utilisateur;

@Repository
public class UtilisateurDAOImpl implements UtilisateurDAO {
	
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Utilisateur> findAllUtilisateurs() {
		Query query = em.createQuery("SELECT e FROM Utilisateur e");
		return (List<Utilisateur>) query.getResultList();
	}

	@Override
	public void inscription(Utilisateur utilisateur) {
		em.merge(utilisateur);
	}

	@Override
	public Utilisateur findByEmail(String email) {
		Utilisateur utilisateur = em.createQuery(
				  "SELECT u from Utilisateur u WHERE u.email = :email", Utilisateur.class).
				  setParameter("email", email).getSingleResult();
		return utilisateur;
	}

	@Override
	public Utilisateur findById(Long id) {
		Utilisateur utilisateur = em.find(Utilisateur.class, id);

		return utilisateur;
	}
}