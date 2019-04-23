package com.nucleus.models;

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
@Table(name="administrators")
public class Administrator {
	
	private int idAdministrator;
	private String adminName;
	private String adminLastNameMother;
	private String adminLastNameFather;
	private String adminUsername;
	private String adminRFC;
	private String adminPassword;
	private char adminGenre;
	
	private Institute idInstitute;
	
	public Administrator() {
		
	}

	public Administrator(int idAdministrator, String adminName, String adminLastNameMother, String adminLastNameFather,
			String adminUsername, String adminRFC, String adminPassword, char adminGenre, Institute idInstitute) {
		super();
		this.idAdministrator = idAdministrator;
		this.adminName = adminName;
		this.adminLastNameMother = adminLastNameMother;
		this.adminLastNameFather = adminLastNameFather;
		this.adminUsername = adminUsername;
		this.adminRFC = adminRFC;
		this.adminPassword = adminPassword;
		this.adminGenre = adminGenre;
		this.idInstitute = idInstitute;
	}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_administrator")
	public int getIdAdministrator() {
		return idAdministrator;
	}

	public void setIdAdministrator(int idAdministrator) {
		this.idAdministrator = idAdministrator;
	}

	
	@Column(name="admin_name")
	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	@Column(name="admin_lastname_mother")
	public String getAdminLastNameMother() {
		return adminLastNameMother;
	}

	public void setAdminLastNameMother(String adminLastNameMother) {
		this.adminLastNameMother = adminLastNameMother;
	}

	@Column(name="admin_lastname_father")
	public String getAdminLastNameFather() {
		return adminLastNameFather;
	}

	public void setAdminLastNameFather(String adminLastNameFather) {
		this.adminLastNameFather = adminLastNameFather;
	}

	@Column(name="admin_username")
	public String getAdminUsername() {
		return adminUsername;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}
	
	@Column(name="admin_rfc")
	public String getAdminRFC() {
		return adminRFC;
	}

	public void setAdminRFC(String adminRFC) {
		this.adminRFC = adminRFC;
	}

	@Column(name="admin_password")
	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	@Column(name="admin_genre")
	public char getAdminGenre() {
		return adminGenre;
	}

	public void setAdminGenre(char adminGenre) {
		this.adminGenre = adminGenre;
	}

	@ManyToOne
	@JoinColumn(name="INSTITUTES_id_institute", foreignKey=@ForeignKey(name="id_institute"))
	public Institute getIdInstitute() {
		return idInstitute;
	}

	public void setIdInstitute(Institute idInstitute) {
		this.idInstitute = idInstitute;
	}

}
