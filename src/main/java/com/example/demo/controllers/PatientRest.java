package com.example.demo.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Login;

@RequestMapping("/patient")
public interface PatientRest {

	@PostMapping(path="/signup")
	public ResponseEntity<String> signup(@RequestBody(required=true) Map<String,String>requestMap);

	/*@PostMapping(path="/login")
	public ResponseEntity<String> login(@RequestBody(required=true) Map<String,String>requestMap);*/

	/*@PostMapping(path="/login")
	public Login login(@RequestBody(required=true) Map<String,String>requestMap);*/

}
