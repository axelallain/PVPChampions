package fr.axelallain.dao;

import java.util.List;

import fr.axelallain.entity.Event;

public interface EventDao {
	
	List<Event> findAllEventsByServeurId(Long id);

	void ajouter(Event event);
	
	List<Event> findAllEventsByServeurIdAndType (Long id, String type);
}
