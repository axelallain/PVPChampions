package fr.axelallain.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	
	@Column(name = "type", nullable = false)
	private String type;
	
	@ManyToMany(mappedBy="serveurs")
	private Collection<Utilisateur> utilisateurs;
	
	@OneToMany(mappedBy="serveur", fetch = FetchType.EAGER)
	private Collection<Event> events;
}
