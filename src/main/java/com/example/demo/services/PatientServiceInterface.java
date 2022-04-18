package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Patient;

public interface PatientServiceInterface {

	Patient UpdatePatient(Patient p);
	void deletePatient(Patient p);
	void deletePatientById(int id);
	Patient getPatient(int id);
	List<Patient> getAllPatients();
    Patient savePatient(Patient p);
	List<Patient> afficherPatient();
}
