package fr.axelallain.entity;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "event")
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "nom", nullable = false)
	private String nom;
	
	@Column(name = "dateParution", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime dateParution;
	
	@Column(name = "description", nullable = true)
	private String description;
	
	@Column(name = "type", nullable = false)
	private String type;
	
	@ManyToOne
	@JoinColumn(name = "serveur_id")
	private Serveur serveur;
	
	@ManyToOne
	@JoinColumn(name = "utilisateur_id")
	private Utilisateur utilisateur;
	
	@OneToMany(mappedBy="event", fetch = FetchType.EAGER)
	private Collection<Commentaire> commentaires;

	@ManyToMany
	@JoinTable(
			name = "event_utilisateur",
			joinColumns = { @JoinColumn(name = "event_id") },
			inverseJoinColumns = { @JoinColumn(name = "utilisateur_id") } )
	private Collection<Utilisateur> utilisateurs;

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

	public LocalDateTime getDateParution() {
		return dateParution;
	}

	public void setDateParution(LocalDateTime dateParution) {
		this.dateParution = dateParution;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Serveur getServeur() {
		return serveur;
	}

	public void setServeur(Serveur serveur) {
		this.serveur = serveur;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Collection<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(Collection<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Collection<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(Collection<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
}
