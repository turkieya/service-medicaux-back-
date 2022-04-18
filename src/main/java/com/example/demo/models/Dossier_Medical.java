package com.example.demo.models;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="dossier")
public class Dossier_Medical implements Serializable{
	 @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private Long id;
	 @Embedded
	 private Set<Antecedent> antecedents;
	 @Override
	public String toString() {
		return "Dossier_Medical [id=" + id + ", antecedents=" + antecedents + ", analyses=" + analyses
				+ ", consultations=" + consultations + ", patient=" + patient + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<Antecedent> getAntecedents() {
		return antecedents;
	}
	public void setAntecedents(Set<Antecedent> antecedents) {
		this.antecedents = antecedents;
	}
	public Set<Analyse> getAnalyses() {
		return analyses;
	}
	public void setAnalyses(Set<Analyse> analyses) {
		this.analyses = analyses;
	}
	public Set<Consultation> getConsultations() {
		return consultations;
	}
	public void setConsultations(Set<Consultation> consultations) {
		this.consultations = consultations;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	@Embedded
	 private Set<Analyse> analyses;
	 @Embedded
	 private Set<Consultation> consultations;
	 @OneToOne(mappedBy = "dossier")
		private Patient patient;
	

}