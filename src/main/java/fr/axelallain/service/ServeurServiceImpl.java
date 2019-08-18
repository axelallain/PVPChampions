package fr.axelallain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.axelallain.dao.ServeurDao;
import fr.axelallain.entity.Serveur;

@Service
@Transactional
public class ServeurServiceImpl implements ServeurService {
	
	@Autowired
	private ServeurDao serveurDao;

	@Override
	public List<Serveur> findAllServeurs() {
		return serveurDao.findAllServeurs();
	}

}
