package com.nucleus.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="economy") 
public class Economy {

	private int idEconomy;
	
	@Column(name="id_economy")
	public int getIdEconomy() {
		return idEconomy;
	}
	public void setIdEconomy(int idEconomy) {
		this.idEconomy = idEconomy;
	}
}
