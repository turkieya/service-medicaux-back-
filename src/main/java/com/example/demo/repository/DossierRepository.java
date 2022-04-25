package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.Dossier_Medical;


public interface DossierRepository extends JpaRepository<Dossier_Medical, Long> {

	@Query(value="insert into Dossier_Medical(id) VALUES (:id)",
			  nativeQuery = true)
	void createDoss(@Param("id")Long id);
}
