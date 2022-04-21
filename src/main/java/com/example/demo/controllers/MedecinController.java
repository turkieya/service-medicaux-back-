package com.example.demo.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.example.demo.services.MedecinService;
import com.example.demo.utils.medicUtils;

public class MedecinController implements MedecinRest {
	@Autowired
	MedecinService medServ;
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public ResponseEntity<String> signup(Map<String, String> requestMap) {
	
		try {
			SimpleMailMessage msg = new SimpleMailMessage();
		    msg.setTo(requestMap.get("email"));
	        msg.setSubject("Compte Ajouté");
		    msg.setText("Pour acceder a votre compte sur MEDICO vous utilisez votre email  "+ requestMap.get("email")+" ,votre mot de passe est "+requestMap.get("password"));
		    javaMailSender.send(msg);
			return medServ.signup(requestMap);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return medicUtils.getResponseEntity("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
