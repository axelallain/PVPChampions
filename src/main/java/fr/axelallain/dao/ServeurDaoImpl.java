package fr.axelallain.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.axelallain.entity.Serveur;

@Repository
public class ServeurDaoImpl implements ServeurDao {
	
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Serveur> findAllServeurs() {
		Query query = em.createQuery("SELECT e FROM Serveur e");
		return (List<Serveur>) query.getResultList();
	}

}
