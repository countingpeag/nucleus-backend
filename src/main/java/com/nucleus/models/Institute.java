package com.nucleus.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="institutes")
public class Institute {

	private int idInstitute;
	private String instituteName;
	private String instituteAddress;
	private String institutePhone;
	
	public Institute() {}
	
	public Institute(String instituteName, String instituteAddress, String institutePhone) {
		this.instituteName = instituteName;
		this.instituteAddress = instituteAddress;
		this.institutePhone = institutePhone;
	}
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_institute")
	public int getIdInstitute() {
		return idInstitute;
	}
	public void setIdInstitute(int idInstitute) {
		this.idInstitute = idInstitute;
	}
	
	@Column(name="institute_name")
	public String getInstituteName() {
		return instituteName;
	}
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}
	
	@Column(name="institute_address")
	public String getInstituteAddress() {
		return instituteAddress;
	}
	public void setInstituteAddress(String instituteAddress) {
		this.instituteAddress = instituteAddress;
	}
	
	@Column(name="institute_phone")
	public String getInstitutePhone() {
		return institutePhone;
	}
	public void setInstitutePhone(String institutePhone) {
		this.institutePhone = institutePhone;
	}
	
	
}
