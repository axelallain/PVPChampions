package fr.axelallain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.axelallain.dao.EventDao;
import fr.axelallain.entity.Event;

@Service
@Transactional
public class EventServiceImpl implements EventService {
	
	@Autowired
	private EventDao eventDao;

	@Override
	public List<Event> findAllEventsByServeurId(Long id) {
		return eventDao.findAllEventsByServeurId(id);
	}
	
	@Override
	public void ajouter(Event event) {
		eventDao.ajouter(event);
	}
	
	@Override
	public List<Event> findAllEventsByServeurIdAndType (Long id, String type) {
		return eventDao.findAllEventsByServeurIdAndType(id, type);
	}

}
