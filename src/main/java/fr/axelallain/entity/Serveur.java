package fr.axelallain.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "serveur")
public class Serveur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nom", nullable = false, unique = true)
	private String nom;
	
	@OneToMany(mappedBy="serveur", fetch = FetchType.EAGER)
	private Collection<Event> events;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Collection<Event> getEvents() {
		return events;
	}

	public void setEvents(Collection<Event> events) {
		this.events = events;
	}
	
}
