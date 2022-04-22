package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Horaires_disp;
import com.example.demo.repository.HoraireRepository;

@Service
public class HoraireService {

	@Autowired
	HoraireRepository horaireRepo;
	
	public Horaires_disp saveHorarire(Horaires_disp h) {
		return horaireRepo.save(h);
	}

	public Optional<Horaires_disp> findById(Long id) {
		return horaireRepo.findById(id);
	}
}
