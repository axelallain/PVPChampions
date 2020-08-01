package fr.axelallain.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name = "utilisateur")
public class Utilisateur implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "description", nullable = true)
	private String description;

	@ManyToOne
	@JoinColumn(name = "serveur_id")
	private Serveur serveur;
	
	@OneToMany(mappedBy="utilisateur", fetch = FetchType.EAGER)
	private Collection<Event> events;
	
	@OneToMany(mappedBy="utilisateur")
	private Collection<Commentaire> commentaires;

	@ManyToMany(mappedBy = "utilisateurs", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Collection<Event> participations;
	
	@Column(name = "image")
	private String image;
	
	public Utilisateur() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Serveur getServeur() {
		return serveur;
	}

	public void setServeur(Serveur serveur) {
		this.serveur = serveur;
	}

	public Collection<Event> getEvents() {
		return events;
	}

	public void setEvents(Collection<Event> events) {
		this.events = events;
	}

	public Collection<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(Collection<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Collection<Event> getParticipations() {
		return participations;
	}

	public void setParticipations(Collection<Event> participations) {
		this.participations = participations;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
