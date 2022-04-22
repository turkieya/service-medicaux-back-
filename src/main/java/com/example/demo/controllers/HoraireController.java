package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Categorie;
import com.example.demo.models.Horaires_disp;
import com.example.demo.services.HoraireService;

@RestController
public class HoraireController implements HoraireRest {

	@Autowired
	HoraireService horServ ; 
	
	@Override
	public Horaires_disp addHoraire(Horaires_disp h) {
		return horServ.saveHorarire(h) ; 	
	}
	
	@Override
	public Horaires_disp findHoraireById (@PathVariable long id)  { 
		return horServ.findById(id).get() ;
	}
}
