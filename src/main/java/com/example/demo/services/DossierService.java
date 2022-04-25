package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.example.demo.models.Dossier_Medical;
import com.example.demo.repository.DossierRepository;

@Service
public class DossierService {

	@Autowired
	DossierRepository dossRep;
	



}
