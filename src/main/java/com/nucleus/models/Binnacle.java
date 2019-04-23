package com.nucleus.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="binnacle")
public class Binnacle {
	private int idBinnacle;
	private String binnacleAction;
	private Date binnacleDate;
	
	private Administrator idAdministrator;
	
	public Binnacle() {
		
	}
	
	public Binnacle(String binnacleAction, Date binnacleDate, Administrator idAdministrator) {
		this.binnacleAction = binnacleAction;
		this.binnacleDate = binnacleDate;
		this.idAdministrator = idAdministrator;
	}


	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_binnacle")
	public int getIdBinnacle() {
		return idBinnacle;
	}

	public void setIdBinnacle(int idBinnacle) {
		this.idBinnacle = idBinnacle;
	}

	@Column(name="binnacle_action")
	public String getBinnacleAction() {
		return binnacleAction;
	}

	public void setBinnacleAction(String binnacleAction) {
		this.binnacleAction = binnacleAction;
	}

	@Column(name="binnacle_date")
	public Date getBinnacleDate() {
		return binnacleDate;
	}

	public void setBinnacleDate(Date binnacleDate) {
		this.binnacleDate = binnacleDate;
	}

	@ManyToOne
	@JoinColumn(name="ADMINISTRATORS_id_administrator", foreignKey=@ForeignKey(name="id_administrator"))
	public Administrator getIdAdministrator() {
		return idAdministrator;
	}

	public void setIdAdministrator(Administrator idAdministrator) {
		this.idAdministrator = idAdministrator;
	}

}
