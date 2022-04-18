package com.example.demo.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categorie implements Serializable{
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 protected Long id;
	 
	 @Column(name = "nom")
	 private String nom ;
	
	@Override
	public String toString() {
		return "Categorie [id=" + id + ", nom=" + nom + ", med=" + med + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Set<Medecin> getMed() {
		return med;
	}
	public void setMed(Set<Medecin> med) {
		this.med = med;
	}
	@OneToMany(cascade = CascadeType.ALL,mappedBy ="cat")
	 private Set<Medecin> med;

}
