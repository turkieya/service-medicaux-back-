package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Categorie;
import com.example.demo.models.Horaires_disp;

@RequestMapping("/horaire")
public interface HoraireRest {
	
	@PostMapping(path="/add")
	public Horaires_disp addHoraire(@RequestBody Horaires_disp h);

	@GetMapping(path = "show/{id}")
	public Horaires_disp findHoraireById (@PathVariable long id);
}
