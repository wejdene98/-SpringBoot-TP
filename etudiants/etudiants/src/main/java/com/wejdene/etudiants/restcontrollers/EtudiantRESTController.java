package com.wejdene.etudiants.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wejdene.etudiants.Service.EtudiantService;
import com.wejdene.etudiants.entities.Etudiant;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EtudiantRESTController {
	@Autowired
	EtudiantService EtudiantService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Etudiant> getAllEtudiants() {
	return EtudiantService.getAllEtudiants();
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Etudiant getEtudiantById(@PathVariable("id") Long id) {
	return EtudiantService.getEtudiant(id);
	}
	@RequestMapping(method = RequestMethod.POST)
	public Etudiant createEtudiant(@RequestBody Etudiant e) {
	return EtudiantService.saveEtudiant(e);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public Etudiant updateEtudiant(@RequestBody Etudiant e) {
	return EtudiantService.updateEtudiant(e);
	}
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteEtudiant(@PathVariable("id") Long id)
	{
		EtudiantService.deleteEtudiantById(id);
	}
	@RequestMapping(value="/etuClasse/{id}",method = RequestMethod.GET)
	public List<Etudiant> getEtudiantsByCatId(@PathVariable("id") Long id) {
	return EtudiantService.findByClasseIdClasse(id);
	}

	}

