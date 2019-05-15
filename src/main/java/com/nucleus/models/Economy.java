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
	private double monthlyIncome;
	private double monthlyExpenditureFood;
	private double monthlyExpenditureRent;
	private double monthlyExpenditureLight;
	private double monthlyExpenditureGas;
	private double monthlyExpenditureTuition;
	private double monthlyExpenditurePayments;
	private double monthlyExpenditureTransport;
	private double monthlyExpenditureDress;
	private double monthlyExpenditureOthers;
	private double monthlyExpenditureTotal;
	private double monthlyIncomeFather;
	private double monthlyIncomeMother;
	private double monthlyIncomeBrothers;
	private double monthlyIncomeOthers;
	private double monthlyIncomeTotal;
	private String sourcesOfIncome;
	private String coments;
	
	
	//private int salaryMonth;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_economy")
	public int getIdEconomy() {
		return idEconomy;
	}
	public void setIdEconomy(int idEconomy) {
		this.idEconomy = idEconomy;
	}
	
	@Column(name="monthly_income")
	public double getMonthlyIncome() {
		return monthlyIncome;
	}
	public void setMonthlyIncome(double monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}
	@Column(name="monthly_expenditure_food")
	public double getMonthlyExpenditureFood() {
		return monthlyExpenditureFood;
	}
	public void setMonthlyExpenditureFood(double monthlyExpenditureFood) {
		this.monthlyExpenditureFood = monthlyExpenditureFood;
	}
	@Column(name="monthly_expenditure_rent")
	public double getMonthlyExpenditureRent() {
		return monthlyExpenditureRent;
	}
	public void setMonthlyExpenditureRent(double monthlyExpenditureRent) {
		this.monthlyExpenditureRent = monthlyExpenditureRent;
	}
	@Column(name="monthly_expenditure_light")
	public double getMonthlyExpenditureLight() {
		return monthlyExpenditureLight;
	}
	public void setMonthlyExpenditureLight(double monthlyExpenditureLight) {
		this.monthlyExpenditureLight = monthlyExpenditureLight;
	}
	@Column(name="monthly_expenditure_gas")
	public double getMonthlyExpenditureGas() {
		return monthlyExpenditureGas;
	}
	public void setMonthlyExpenditureGas(double monthlyExpenditureGas) {
		this.monthlyExpenditureGas = monthlyExpenditureGas;
	}
	@Column(name="monthly_expenditure_tuition")
	public double getMonthlyExpenditureTuition() {
		return monthlyExpenditureTuition;
	}
	public void setMonthlyExpenditureTuition(double monthlyExpenditureTuition) {
		this.monthlyExpenditureTuition = monthlyExpenditureTuition;
	}
	@Column(name="monthly_expenditure_payments")
	public double getMonthlyExpenditurePayments() {
		return monthlyExpenditurePayments;
	}
	public void setMonthlyExpenditurePayments(double monthlyExpenditurePayments) {
		this.monthlyExpenditurePayments = monthlyExpenditurePayments;
	}
	@Column(name="monthly_expenditure_transport")
	public double getMonthlyExpenditureTransport() {
		return monthlyExpenditureTransport;
	}
	public void setMonthlyExpenditureTransport(double monthlyExpenditureTransport) {
		this.monthlyExpenditureTransport = monthlyExpenditureTransport;
	}
	@Column(name="monthly_expenditure_dress")
	public double getMonthlyExpenditureDress() {
		return monthlyExpenditureDress;
	}
	public void setMonthlyExpenditureDress(double monthlyExpenditureDress) {
		this.monthlyExpenditureDress = monthlyExpenditureDress;
	}
	@Column(name="monthly_expenditure_others")
	public double getMonthlyExpenditureOthers() {
		return monthlyExpenditureOthers;
	}
	public void setMonthlyExpenditureOthers(double monthlyExpenditureOthers) {
		this.monthlyExpenditureOthers = monthlyExpenditureOthers;
	}
	@Column(name="monthly_expenditure_total")
	public double getMonthlyExpenditureTotal() {
		return monthlyExpenditureTotal;
	}
	public void setMonthlyExpenditureTotal(double monthlyExpenditureTotal) {
		this.monthlyExpenditureTotal = monthlyExpenditureTotal;
	}
	@Column(name="monthly_income_father")
	public double getMonthlyIncomeFather() {
		return monthlyIncomeFather;
	}
	public void setMonthlyIncomeFather(double monthlyIncomeFather) {
		this.monthlyIncomeFather = monthlyIncomeFather;
	}
	@Column(name="monthly_income_mother")
	public double getMonthlyIncomeMother() {
		return monthlyIncomeMother;
	}
	public void setMonthlyIncomeMother(double monthlyIncomeMother) {
		this.monthlyIncomeMother = monthlyIncomeMother;
	}
	@Column(name="monthly_income_brothers")
	public double getMonthlyIncomeBrothers() {
		return monthlyIncomeBrothers;
	}
	public void setMonthlyIncomeBrothers(double monthlyIncomeBrothers) {
		this.monthlyIncomeBrothers = monthlyIncomeBrothers;
	}
	@Column(name="monthly_income_others")
	public double getMonthlyIncomeOthers() {
		return monthlyIncomeOthers;
	}
	public void setMonthlyIncomeOthers(double monthlyIncomeOthers) {
		this.monthlyIncomeOthers = monthlyIncomeOthers;
	}
	@Column(name="monthly_income_total")
	public double getMonthlyIncomeTotal() {
		return monthlyIncomeTotal;
	}
	public void setMonthlyIncomeTotal(double monthlyIncomeTotal) {
		this.monthlyIncomeTotal = monthlyIncomeTotal;
	}
	@Column(name="sources_of_income")
	public String getSourcesOfIncome() {
		return sourcesOfIncome;
	}
	public void setSourcesOfIncome(String sourcesOfIncome) {
		this.sourcesOfIncome = sourcesOfIncome;
	}
	@Column(name="coments")
	public String getComents() {
		return coments;
	}
	public void setComents(String coments) {
		this.coments = coments;
	}
	
	
	
	/*@Column(name="economy_salary_month")
	public int getSalaryMonth() {
		return salaryMonth;
	}
	public void setSalaryMonth(int salaryMonth) {
		this.salaryMonth = salaryMonth;
	}*/
	
	
}
