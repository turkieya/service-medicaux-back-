package com.example.demo.services;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.models.Login;
import com.example.demo.models.Medecin;
import com.example.demo.models.Patient;
import com.example.demo.repository.LoginRepository;
import com.example.demo.repository.MedecinRepository;
import com.example.demo.repository.PatientRepository;
import com.example.demo.utils.medicUtils;

@Service
public class MedecinService implements MedecinServiceInterface {

	@Autowired
	LoginRepository logRepo;
	
	@Autowired
	MedecinRepository medRepo;

	public ResponseEntity<String> signup(Map<String, String> requestMap){
		//log.info("Inside signup()",requestMap);
		try {
		if(validateSignUpMap(requestMap)) {
			Medecin medcin = medRepo.findByEmail(requestMap.get("email"));
			if(Objects.isNull(medcin)) {
				medRepo.save(getMedcinFromMap(requestMap));
				logRepo.save(getUserFromMap(requestMap));
				return medicUtils.getResponseEntity("Succesfully Registered!", HttpStatus.OK);
			}else {
				return medicUtils.getResponseEntity("Email already exists !", HttpStatus.BAD_REQUEST);
			}
		
		}
		else {
			return medicUtils.getResponseEntity("Invalid Data", HttpStatus.BAD_REQUEST);
		}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return medicUtils.getResponseEntity("Something is wrong", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private boolean validateSignUpMap(Map<String, String> requestMap) {
		if(requestMap.containsKey("nom")&& requestMap.containsKey("prenom") && requestMap.containsKey("email") && requestMap.containsKey("password")) {
			return true;
		}
		return false;
	}

	private Medecin getMedcinFromMap(Map<String, String> requestMap) {
		Medecin medecin = new Medecin();
		medecin.setNom(requestMap.get("nom"));
		medecin.setPrenom(requestMap.get("prenom"));
		medecin.setEmail(requestMap.get("email"));
		Random random = new Random();
		Long id=random.nextLong();
		System.out.println(id);
		medecin.setId(id);
		//patient.setPassword(requestMap.get("password"));
		medecin.setPassword(requestMap.get("password"));
		return medecin;
	}
	private Login getUserFromMap(Map<String, String> requestMap) {
		Login user = new Login();
		user.setEmail(requestMap.get("email"));
		//patient.setPassword(requestMap.get("password"));
		user.setPassword(requestMap.get("password"));
		//user.setPassword(encoder.encode(requestMap.get("password")));

		user.setRole("medecin");
		String email=requestMap.get("email");
		System.out.println(email);
		long n=logRepo.findMedecinId(email);
		System.out.println(n);

		user.setId(logRepo.findMedecinId(email));
		
		return user;
	}
	
	public List<Medecin> findMedecins(Long id){
		return medRepo.findMedecinId(id);
	}
	
	
	public Optional<Medecin> findById(Long id) {
		return medRepo.findById(id);
	}


}
