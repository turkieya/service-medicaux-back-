package com.example.demo.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Embeddable
public class Consultation implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id;

	private String commentaire;
	private String motif; 
	@Override
	public String toString() {
		return "Consultation [id=" + id + ", commentaire=" + commentaire + ", motif=" + motif + ", date=" + date + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date date;
	@ManyToMany(cascade = CascadeType.ALL,mappedBy ="consultations")
	private Set<Medicament> medicaments;
}
