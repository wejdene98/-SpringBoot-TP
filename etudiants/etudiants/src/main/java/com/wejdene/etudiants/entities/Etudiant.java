package com.wejdene.etudiants.entities;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Etudiant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idetudiant;
	@NotNull
	@Size (min = 4,max = 15)
	private String nom;
	@Min(value = 0)
	@Max(value = 20)
	private Double moyenne;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateInsrip;
	
	@ManyToOne
	private Classe classe;

	public Etudiant() {
		super();
		}
		public Etudiant(String nom, Double moyenne, Date dateInscrip) {
		super();
		this.nom = nom;
		this.moyenne = moyenne;
		this.dateInsrip = dateInscrip;
		}
		public Long getIdetudiant() {
			return idetudiant;
		}
		public void setIdetudiant(Long idetudiant) {
			this.idetudiant = idetudiant;
		}
		public String getNom() {
			return nom;
		}
		public Classe getClasse() {
			return classe;
		}
		public void setClasse(Classe classe) {
			this.classe = classe;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public Double getMoyenne() {
			return moyenne;
		}
		public void setMoyenne(Double moyenne) {
			this.moyenne = moyenne;
		}
		public Date getDateInsrip() {
			return dateInsrip;
		}
		public void setDateInsrip(Date dateInsrip) {
			this.dateInsrip = dateInsrip;
		}
		@Override
		public String toString() {
			return "etudiant [idetudiant=" + idetudiant + ", nom=" + nom + ", moyenne=" + moyenne + ", dateInsrip="
					+ dateInsrip + ", getIdetudiant()=" + getIdetudiant() + ", getNom()=" + getNom() + ", getMoyenne()="
					+ getMoyenne() + ", getDateInsrip()=" + getDateInsrip() + "]";
		}
		
		
}
