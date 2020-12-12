package com.wejdene.etudiants.repos;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.wejdene.etudiants.entities.Classe;
import com.wejdene.etudiants.entities.Etudiant;

@RepositoryRestResource(path = "rest")
public interface EtudiantRepository extends JpaRepository< Etudiant, Long> {
	List<Etudiant> findByNom(String nom);
	List<Etudiant> findByNomContains(String nom); 
	
	
	@Query("select e from Etudiant e where e.nom like %:nom and e.moyenne > :moyenne")
	List<Etudiant> findByNomMoyenne (@Param("nom") String nom,@Param("moyenne") Double moyenne);

	@Query("select e from Etudiant e where e.classe = ?1")
	List<Etudiant> findByClasse (Classe classe);
	
	List<Etudiant> findByClasseIdClasse(Long id);
	
	List<Etudiant> findByOrderByNomAsc();
	
	@Query("select e from Etudiant e order by e.nom ASC, e.moyenne DESC")
	List<Etudiant> trierEtudiantNomMoyenne ();
}
