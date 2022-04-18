package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.Patient;
import com.example.demo.models.User;

public interface PatientRepository extends JpaRepository<Patient, Integer>{

	Patient findByEmailId(@Param("email") String email);
	boolean existsByEmail(String email);
	
	@Query("select p from Patient p where p.email =:email and p.password =:password")
	Patient findByEmailAndPassword (@Param("email") String email,@Param("password") String password);
	Patient findByEmail(@Param("email") String email);
}
