package com.example.demo.models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@Embeddable
public class Antecedent implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id;
	private String categorie;
	private String nom;
	@Override
	public String toString() {
		return "Antecedent [id=" + id + ", categorie=" + categorie + ", nom=" + nom + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

}
