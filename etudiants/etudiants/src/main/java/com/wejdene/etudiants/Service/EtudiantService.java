package com.wejdene.etudiants.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.wejdene.etudiants.entities.Classe;
import com.wejdene.etudiants.entities.Etudiant;

public interface EtudiantService {
	Etudiant saveEtudiant(Etudiant e);
	Etudiant updateEtudiant(Etudiant e);
	void deleteEtudiant(Etudiant e);
	void deleteEtudiantById(Long id);
	Etudiant getEtudiant(Long id);
	List<Etudiant> getAllEtudiants();
	Page<Etudiant> getAllEtudiantsParPage(int page, int size);
	List<Etudiant> findByNomEtudiant(String nom);
	List<Etudiant> findByNomEtudiantContains(String nom);
	List<Etudiant> findByNomMoyenne (String nom, Double moyenne);
	List<Etudiant> findByClasse(Classe classe);
	List<Etudiant> findByClasseIdClasse(Long id);
	List<Etudiant> findByOrderByNomEtudiantAsc();
	List<Etudiant> trierEtudiantNomMoyenne();
	
	

}
