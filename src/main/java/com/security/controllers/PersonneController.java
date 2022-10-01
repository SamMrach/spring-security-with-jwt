package com.security.controllers;

import java.util.List;
import java.util.Optional;

import com.security.entities.Personne;
import com.security.repositories.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PersonneController {
	
	@Autowired
	private PersonneRepository personneRepo;
	
	@RequestMapping(value="/personnes",method=RequestMethod.GET)
	public List<Personne> getPersonnes() {
		return personneRepo.findAll();
	}
	
	@RequestMapping(value="/personnes/{id}",method=RequestMethod.GET)
	public Optional<Personne> getPersonne(@PathVariable Long id){
		return personneRepo.findById(id);
	}

	@RequestMapping(value="/personnes",method = RequestMethod.POST)
	public Personne SavePersonne(@RequestBody Personne per){
		return personneRepo.save(per);
	}
}
