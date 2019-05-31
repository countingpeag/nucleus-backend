package com.nucleus.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="economy") 
public class Economy {

	private int idEconomy;
	private int salaryMonth;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_economy")
	public int getIdEconomy() {
		return idEconomy;
	}
	public void setIdEconomy(int idEconomy) {
		this.idEconomy = idEconomy;
	}
	
	
	@Column(name="economy_salary_month")
	public int getSalaryMonth() {
		return salaryMonth;
	}
	public void setSalaryMonth(int salaryMonth) {
		this.salaryMonth = salaryMonth;
	}

}
