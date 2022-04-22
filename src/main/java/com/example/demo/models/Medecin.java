package com.example.demo.models;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="medecin")
public class Medecin extends User implements Serializable{
	@Column(name = "matricule")
	 private Long matricule ; 

	@Column(name = "specialite")
    private String specialite ;
	
	@Column(name = "prix_consultation")
    private float prix_consult;
	 
	@OneToMany(mappedBy="medecin")
	private List<Horaires_disp> horaires;
	@ManyToMany(cascade = CascadeType.ALL, mappedBy="med")
    private Set<Patient> pat;
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Categorie cat;
	
	 @Override
	public String toString() {
		return "Medecin ["+super.toString()+"matricule=" + matricule + ", statut=" + specialite + ", prix_consult=" + prix_consult + "]";
	}
	
	public Long getMatricule() {
		return matricule;
	}
	 public Medecin (String nom , String prenom, String email , String password , String sexe, Long matricule,String specialite, float prix_consult) {
		 super( nom,prenom,email,password,sexe);
		 this.matricule=matricule;
		 this.specialite=specialite;
		 this.prix_consult=prix_consult;
		 
	 }
	public Medecin() {
		// TODO Auto-generated constructor stub
	}

	public void setMatricule(Long matricule) {
		this.matricule = matricule;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String statut) {
		this.specialite = statut;
	}
	public float getPrix_consult() {
		return prix_consult;
	}
	public void setPrix_consult(float prix_consult) {
		this.prix_consult = prix_consult;
	} 

	 
}