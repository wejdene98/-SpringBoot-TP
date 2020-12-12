package com.wejdene.etudiants;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.wejdene.etudiants.Service.EtudiantService;
import com.wejdene.etudiants.entities.Classe;
import com.wejdene.etudiants.entities.Etudiant;
import com.wejdene.etudiants.repos.EtudiantRepository;

@SpringBootTest
class EtudiantsApplicationTests {
	
	
	@Autowired
	private EtudiantRepository EtudiantRepository;
	
	@Autowired
	private EtudiantService EtudiantService;
	
	
	@Test
	public void testCreateEtudiant() {
	Etudiant etd = new Etudiant("wejdene bedoui",18.65,new Date());
	EtudiantRepository.save(etd);
	}
	
	
	 @Test
	 public void testFindEtudiant()
	 {
	 Etudiant e = EtudiantRepository.findById(1L).get();
	 System.out.println(e);
	 }
	 
	 
	 @Test
	 public void testUpdateEtudiant()
	 {
	 Etudiant e = EtudiantRepository.findById(2L).get();
	 e.setNom("aymen");
	 EtudiantRepository.save(e);
	 
	 
	 }
	@Test
	 public void testDeleteEtudiant()
	 {
		 EtudiantRepository.deleteById(1L);;
		 }
	
	
	 @Test
	 public void ListerTousEtudiant()
	 {
	 List<Etudiant> etd = EtudiantRepository.findAll();
	 for (Etudiant e : etd)
	 {
	 System.out.println();
	 }
	 }
	 
	 
	 @Test
	 public void testFindByNomEtudiant()
	 {
	 List<Etudiant> etd = EtudiantRepository.findByNom("ibtihel");
	 for (Etudiant e : etd)
	 {
	 System.out.println(e);
	 }
	 }
	 

	 @Test
	 public void testFindByNomEtudiantContains()
	 {
		 Page<Etudiant> etd = EtudiantService.getAllEtudiantsParPage(0,2);
		 System.out.println(etd.getSize());
	
		 System.out.println(etd.getTotalElements());
		 System.out.println(etd.getTotalPages());
		 
		 etd.getContent().forEach(e -> {System.out.println(e.toString());
		  });
		 /*ou bien
		 for (Etudiant e : etd)
		 {
		 System.out.println(e);
		 } */
	 }
	 
	 
	 @Test
	 public void findByClasse()
	 {
	 Classe cal = new Classe();
	 cal.setIdClasse(1L);
	 List<Etudiant> etd = EtudiantRepository.findByClasse(cal);
	 for (Etudiant e : etd)
	 {
	 System.out.println(e);
	 }
	 }
	 
	 @Test
	 public void findByClasseIdClasse()
	 {
	 List<Etudiant> etd = EtudiantRepository.findByClasseIdClasse(1L);
	 for (Etudiant e : etd)
	 {
	 System.out.println(e);
	 }
	  }
	 
	 
	 @Test
	 public void testTrierEtudiantNomMoyenne()
	 {
	 List<Etudiant> etd = EtudiantRepository.trierEtudiantNomMoyenne();
	 for (Etudiant e : etd)
	 {
	 System.out.println(e);
	 }
	 }


}

