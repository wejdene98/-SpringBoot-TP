package com.wejdene.etudiants.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.wejdene.etudiants.entities.Classe;
import com.wejdene.etudiants.entities.Etudiant;
import com.wejdene.etudiants.repos.EtudiantRepository;

@Service
public class EtudiantServiceImpl implements EtudiantService {
 
	@Autowired
	EtudiantRepository EtudiantRepository;
	
	@Override
	public Etudiant saveEtudiant(Etudiant e) {
		// TODO Auto-generated method stub
		return EtudiantRepository.save(e);
	}

	@Override
	public Etudiant updateEtudiant(Etudiant e) {
		// TODO Auto-generated method stub
		return EtudiantRepository.save(e);
	}

	@Override
	public void deleteEtudiant(Etudiant e) {
		// TODO Auto-generated method stub
		EtudiantRepository.delete(e);
		
	}
	@Override
	public void deleteEtudiantById(Long id) {
		// TODO Auto-generated method stub
		EtudiantRepository.deleteById(id);
	}

	@Override
	public Etudiant getEtudiant(Long id) {
		// TODO Auto-generated method stub
		return EtudiantRepository.findById(id).get();
	}

	@Override
	public List<Etudiant> getAllEtudiants() {
		// TODO Auto-generated method stub
		return  EtudiantRepository.findAll() ;
	}
	
	@Override
	public Page<Etudiant> getAllEtudiantsParPage(int page, int size) {
	return EtudiantRepository.findAll(PageRequest.of(page, size));
	}
	
	@Override
	public List<Etudiant> findByNomEtudiant(String nom) {
	return EtudiantRepository.findByNom(nom);
	}
	
	@Override
	public List<Etudiant> findByNomEtudiantContains(String nom) {
	return EtudiantRepository.findByNomContains(nom);
	}
	
	@Override
	public List<Etudiant> findByNomMoyenne(String nom, Double moyenne) {
		return EtudiantRepository.findByNomMoyenne(nom, moyenne);
	}
	
	@Override
	public List<Etudiant> findByClasse(Classe classe) {
	return EtudiantRepository.findByClasse(classe);
	}
	
	@Override
	public List<Etudiant> findByClasseIdClasse(Long id) {
	return EtudiantRepository.findByClasseIdClasse(id);
	}
	
	@Override
	public List<Etudiant> findByOrderByNomEtudiantAsc() {
	return EtudiantRepository.findByOrderByNomAsc();
	}
	
	@Override
	public List<Etudiant> trierEtudiantNomMoyenne() {
	return EtudiantRepository.trierEtudiantNomMoyenne();
	}

}
