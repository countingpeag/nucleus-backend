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
	private Integer income;
	private Integer feeding;
	private Integer rent;
	private Integer light;
	private Integer gas;
	private Integer tuition;
	private Integer bills;
	private Integer transport;
	private Integer clothing;
	private Integer othersOut;
	private Integer totalOut;
	private Integer father;
	private Integer mother;
	private Integer siblings;
	private Integer othersIn;
	private Integer totalIn;
	private String fixedIncome;
	private String comments;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_economy")
	public int getIdEconomy() {
		return idEconomy;
	}
	public void setIdEconomy(int idEconomy) {
		this.idEconomy = idEconomy;
	}
	@Column(name="economy_income")
	public Integer getIncome() {
		return income;
	}
	public void setIncome(Integer income) {
		this.income = income;
	}
	@Column(name="economy_feeding")
	public Integer getFeeding() {
		return feeding;
	}
	public void setFeeding(Integer feeding) {
		this.feeding = feeding;
	}
	@Column(name="economy_rent")
	public Integer getRent() {
		return rent;
	}
	public void setRent(Integer rent) {
		this.rent = rent;
	}
	@Column(name="economy_light")
	public Integer getLight() {
		return light;
	}
	public void setLight(Integer light) {
		this.light = light;
	}
	@Column(name="economy_gas")
	public Integer getGas() {
		return gas;
	}
	public void setGas(Integer gas) {
		this.gas = gas;
	}
	@Column(name="economy_tuition")
	public Integer getTuition() {
		return tuition;
	}
	public void setTuition(Integer tuition) {
		this.tuition = tuition;
	}
	@Column(name="economy_bills")
	public Integer getBills() {
		return bills;
	}
	public void setBills(Integer bills) {
		this.bills = bills;
	}
	@Column(name="economy_transport")
	public Integer getTransport() {
		return transport;
	}
	public void setTransport(Integer transport) {
		this.transport = transport;
	}
	@Column(name="economy_clothing")
	public Integer getClothing() {
		return clothing;
	}
	public void setClothing(Integer clothing) {
		this.clothing = clothing;
	}
	@Column(name="economy_othersout")
	public Integer getOthersOut() {
		return othersOut;
	}
	public void setOthersOut(Integer othersOut) {
		this.othersOut = othersOut;
	}
	@Column(name="economy_totalout")
	public Integer getTotalOut() {
		return totalOut;
	}
	public void setTotalOut(Integer totalOut) {
		this.totalOut = totalOut;
	}
	@Column(name="economy_father")
	public Integer getFather() {
		return father;
	}
	public void setFather(Integer father) {
		this.father = father;
	}
	@Column(name="economy_mother")
	public Integer getMother() {
		return mother;
	}
	public void setMother(Integer mother) {
		this.mother = mother;
	}
	@Column(name="economy_siblings")
	public Integer getSiblings() {
		return siblings;
	}
	public void setSiblings(Integer siblings) {
		this.siblings = siblings;
	}
	@Column(name="economy_othersin")
	public Integer getOthersIn() {
		return othersIn;
	}
	public void setOthersIn(Integer othersIn) {
		this.othersIn = othersIn;
	}
	@Column(name="economy_totalin")
	public Integer getTotalIn() {
		return totalIn;
	}
	public void setTotalIn(Integer totalIn) {
		this.totalIn = totalIn;
	}
	@Column(name="economy_fixedIncome")
	public String getFixedIncome() {
		return fixedIncome;
	}
	public void setFixedIncome(String fixedIncome) {
		this.fixedIncome = fixedIncome;
	}
	@Column(name="economy_comments")
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

}
