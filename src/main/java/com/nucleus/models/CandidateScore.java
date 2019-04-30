package com.nucleus.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="candidatescore") //Corregir nombre en la base de datos
public class CandidateScore {

	private int idScore;
	private int finalScore;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_score")
	public int getIdScore() {
		return idScore;
	}
	public void setIdScore(int idScore) {
		this.idScore = idScore;
	}
	
	@Column(name="final_score")
	public int getFinalScore() {
		return finalScore;
	}
	public void setFinalScore(int finalScore) {
		this.finalScore = finalScore;
	}
	
	
}
