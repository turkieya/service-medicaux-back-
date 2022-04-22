package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Horaires_disp;

public interface HoraireRepository extends JpaRepository<Horaires_disp,Long> {

}
