package fr.axelallain.dao;

import java.util.List;

import fr.axelallain.entity.Serveur;

public interface ServeurDao {
	
	List<Serveur> findAllServeurs();

}
