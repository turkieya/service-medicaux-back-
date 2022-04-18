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
	 private int matricule ; 

	@Column(name = "statut")
    private String statut ;
	
	@Column(name = "prix_consultation")
    private float prix_consult;
	 
	 @Override
	public String toString() {
		return "Medecin ["+super.toString()+"matricule=" + matricule + ", statut=" + statut + ", prix_consult=" + prix_consult + "]";
	}
	
	public int getMatricule() {
		return matricule;
	}
	 public Medecin (String nom , String prenom, String email , String password , String sexe, int matricule,String statut, float prix_consult) {
		 super( nom,prenom,email,password,sexe);
		 this.matricule=matricule;
		 this.statut=statut;
		 this.prix_consult=prix_consult;
		 
	 }
	public Medecin() {
		// TODO Auto-generated constructor stub
	}

	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public float getPrix_consult() {
		return prix_consult;
	}
	public void setPrix_consult(float prix_consult) {
		this.prix_consult = prix_consult;
	} 
	@OneToMany(mappedBy="medecin")
	private List<Horaires_disp> horaires;
	@ManyToMany(cascade = CascadeType.ALL, mappedBy="med")
    private Set<Patient> pat;
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Categorie cat;
	 
}