package fr.axelallain.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.axelallain.entity.Event;

@Repository
public class EventDaoImpl implements EventDao {
	
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> findAllEventsByServeurId(Long id) {
		Query query = em.createQuery("SELECT e FROM Event e WHERE e.serveur.id=:id").setParameter("id", id);
		
		return (List<Event>) query.getResultList();
	}
	
	@Override
	public void ajouter(Event event) {
		em.merge(event);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Event> findAllEventsByServeurIdAndType (Long id, String type) {
		Query query = em.createQuery("SELECT e FROM Event e WHERE e.serveur.id=:id AND e.type=:type").setParameter("id", id).setParameter("type", type);
		
		return (List<Event>) query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Event> findAllEventsByUtilisateurId(Long id) {
		Query query = em.createQuery("SELECT e FROM Event e WHERE e.utilisateur.id=:id").setParameter("id", id);
		
		return (List<Event>) query.getResultList();
	}
	
	@Override
	public void delete(Long id) {
		em.createQuery("delete from Event e where e.id=:id").setParameter("id", id).executeUpdate();
	}
	
	@Override
	public Event findEventById(Long id) {
		Event event = em.find(Event.class, id);
		
		return event;
	}

}
