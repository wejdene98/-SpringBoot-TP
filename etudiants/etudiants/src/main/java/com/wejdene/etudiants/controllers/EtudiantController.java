package com.wejdene.etudiants.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import com.wejdene.etudiants.Service.EtudiantService;
import com.wejdene.etudiants.entities.Etudiant;

@Controller
public class EtudiantController {
	@Autowired
	EtudiantService EtudiantService;

	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		modelMap.addAttribute("etudiant", new Etudiant());
		modelMap.addAttribute("mode", "new");
		return "formEtudiant";
	}

	@RequestMapping("/modifierEtudiant")
	public String editerEtudiant(@RequestParam("id") Long id,ModelMap modelMap) {
		Etudiant e = EtudiantService.getEtudiant(id);
		modelMap.addAttribute("etudiant", e);
		modelMap.addAttribute("mode", "edit");
		return "formEtudiant";
	}
	
	
	@RequestMapping("/saveEtudiant")
	public String saveEtudiant(@Valid Etudiant etudiant, 
			 BindingResult bindingResult) {
	
		if (bindingResult.hasErrors()) return "formEtudiant"; 
		
		EtudiantService.saveEtudiant(etudiant);
		return "formEtudiant";
	}
	/*
	 * @RequestMapping("/ListeEtudiants") public String ListeEtudiants(ModelMap
	 * modelMap) { List<Etudiant> etd = EtudiantService.getAllEtudiants();
	 * modelMap.addAttribute("Etudiants",etd); return "ListeEtudiants"; }
	 */

	@RequestMapping("/supprimerEtudiant")
	public String supprimerEtudiant(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		EtudiantService.deleteEtudiantById(id);
		Page<Etudiant> etd = EtudiantService.getAllEtudiantsParPage(page, size);
		modelMap.addAttribute("Etudiant", etd);
		modelMap.addAttribute("pages", new int[etd.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "ListeEtudiants";
	}


	@RequestMapping("/updateEtudiant")
	public String updateEtudiant(@ModelAttribute("Etudiant") Etudiant Etudiant, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
		// conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateInscrip = dateformat.parse(String.valueOf(date));
		Etudiant.setDateInsrip(dateInscrip);

		EtudiantService.updateEtudiant(Etudiant);
		List<Etudiant> etd = EtudiantService.getAllEtudiants();
		modelMap.addAttribute("Etudiants", etd);
		return "ListeEtudiants";
	}

	@RequestMapping("/ListeEtudiants")
	public String ListeEtudiants(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Page<Etudiant> etd = EtudiantService.getAllEtudiantsParPage(page, size);
		modelMap.addAttribute("Etudiant", etd);
		modelMap.addAttribute("pages", new int[etd.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "ListeEtudiants";
	}

}
