package com.wejdene.etudiants.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Classe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idClasse;
	private String libelle;
	private String description;
	
	@OneToMany(mappedBy = "classe")
	@JsonIgnore
	private List<Etudiant> Etudiants;

	

	public Classe(String libelle, String description, List<Etudiant> Etudiants) {
		super();
		this.libelle = libelle;
		this.description = description;
		this.Etudiants = Etudiants;
	}
	public long getIdClasse() {
		return idClasse;
	}
	public void setIdClasse(long idClasse) {
		this.idClasse = idClasse;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
