package fr.axelallain.service;

import java.util.List;

import fr.axelallain.entity.Event;

public interface EventService {
	
	List<Event> findAllEventsByServeurId(Long id);

	void ajouter(Event event);
}
