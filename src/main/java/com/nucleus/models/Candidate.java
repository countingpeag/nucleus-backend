package com.nucleus.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 
@Table(name="candidates") 
public class Candidate {
	
	private int idCandidate;
	private String candidateName;
	private String candidateLastNameFather;
	private String candidateLastNameMother;
	private Date candidateBirthDate;
	private String candidateCivilStatus;
	private String candidateGenre;
	private int candidateAge;
	private String candidateMunicipalityBorn;
	private String candidateLocalityBorn;
	private String candidateStateBorn;
	private String candidateCurrentStreet;
	private String candidateCurrentHouseNumber;
	private String candidateNeighborhood;
	private int candidateCurrentZipCode;
	private String candidateCurrentMunicipality;
	private String candidateCurrentLocality;
	private String candidateCurrentState;
	private long candidateCellPhone;
	private long candidatePersonalPhone;
    private String candidateEmail;
    private String candidateFatherName;
    private String candidateMotherName;
    private String candidateMotherOccupation;
    private String candidateFatherOccupation;
    private long candidateMotherPhone;
    private long candidateFatherPhone;
    private  String candidateMiddleSchool;
    private String candidateMunicipalitySchool;
    private String candidateStateSchool;
    private String candidateSchoolType;
    private String candidateSchoolRegime;
    private String candidateSchoolKey;
    private Date candidateEndDate;
    private String candidateShift;
    private int candidateScore;
    private String candidateGroup;
    private Date candidateCreationDate;
    
	private Health health; 
	private Preference preference;
	private Economy economy;
	private Specialty specialty;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_candidates")
	public int getIdCandidate() {
		return idCandidate;
	}
	
	public void setIdCandidate(int idCandidate) {
		this.idCandidate = idCandidate;
	}
	
	@Column(name="candidate_name")//para decir que es la columna como esta en la base de datos
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	
	@Column(name="candidate_lastname_father")
	public String getCandidateLastNameFather() {
		return candidateLastNameFather;
	}
	public void setCandidateLastNameFather(String candidateLastNameFather) {
		this.candidateLastNameFather = candidateLastNameFather;
	}
	
	@Column(name="candidate_lastname_mother")
	public String getCandidateLastNameMother() {
		return candidateLastNameMother;
	}
	public void setCandidateLastNameMother(String candidateLastNameMother) {
		this.candidateLastNameMother = candidateLastNameMother;
	}
	
	@Column(name="candidate_birthday")
	public Date getCandidateBirthDate() {
		return candidateBirthDate;
	}
	public void setCandidateBirthDate(Date candidateBirthDate) {
		this.candidateBirthDate = candidateBirthDate;
	}
	
	@Column(name="candidate_civilstatus")
	public String getCandidateCivilStatus() {
		return candidateCivilStatus;
	}
	
	public void setCandidateCivilStatus(String candidateCivilStatus) {
		this.candidateCivilStatus = candidateCivilStatus;
	}

	@Column(name="candidate_genre")
	public String getCandidateGenre() {
		return candidateGenre;
	}
	public void setCandidateGenre(String candidateGenre) {
		this.candidateGenre = candidateGenre;
	}
	
	@Column(name="candidate_age")
	public int getCandidateAge() {
		return candidateAge;
	}
	public void setCandidateAge(int candidateAge) {
		this.candidateAge = candidateAge;
	}
	
	@Column(name="candidate_municipality_born")
	public String getCandidateMunicipalityBorn() {
		return candidateMunicipalityBorn;
	}
	public void setCandidateMunicipalityBorn(String candidateMunicipalityBorn) {
		this.candidateMunicipalityBorn = candidateMunicipalityBorn;
	}
	
	@Column(name="candidate_locality_born")
	public String getCandidateLocalityBorn() {
		return candidateLocalityBorn;
	}
	public void setCandidateLocalityBorn(String candidateLocalityBorn) {
		this.candidateLocalityBorn = candidateLocalityBorn;
	}
	
	@Column(name="candidate_state_born")
	public String getCandidateStateBorn() {
		return candidateStateBorn;
	}
	public void setCandidateStateBorn(String candidateStateBorn) {
		this.candidateStateBorn = candidateStateBorn;
	}
	
	@Column(name="candidate_current_street")
	public String getCandidateCurrentStreet() {
		return candidateCurrentStreet;
	}
	public void setCandidateCurrentStreet(String candidateCurrentStreet) {
		this.candidateCurrentStreet = candidateCurrentStreet;
	}
	
	@Column(name="candidate_current_housenumber")
	public String getCandidateCurrentHouseNumber() {
		return candidateCurrentHouseNumber;
	}
	public void setCandidateCurrentHouseNumber(String candidateCurrentHouseNumber) {
		this.candidateCurrentHouseNumber = candidateCurrentHouseNumber;
	}
	
	@Column(name="candidate_current_neighborhood")
	public String getCandidateNeighborhood() {
		return candidateNeighborhood;
	}
	public void setCandidateNeighborhood(String candidateNeighborhood) {
		this.candidateNeighborhood = candidateNeighborhood;
	}
	
	@Column(name="candidate_current_zipcode")
	public int getCandidateCurrentZipCode() {
		return candidateCurrentZipCode;
	}
	public void setCandidateCurrentZipCode(int candidateCurrentZipCode) {
		this.candidateCurrentZipCode = candidateCurrentZipCode;
	}
	
	@Column(name="candidate_current_municipality")
	public String getCandidateCurrentMunicipality() {
		return candidateCurrentMunicipality;
	}
	public void setCandidateCurrentMunicipality(String candidateCurrentMunicipality) {
		this.candidateCurrentMunicipality = candidateCurrentMunicipality;
	}
	
	@Column(name="candidate_current_locality")
	public String getCandidateCurrentLocality() {
		return candidateCurrentLocality;
	}
	public void setCandidateCurrentLocality(String candidateCurrentLocality) {
		this.candidateCurrentLocality = candidateCurrentLocality;
	}
	
	@Column(name="candidate_current_state")
	public String getCandidateCurrentState() {
		return candidateCurrentState;
	}
	public void setCandidateCurrentState(String candidateCurrentState) {
		this.candidateCurrentState = candidateCurrentState;
	}
	
	@Column(name="candidate_cellphone")
	public long getCandidateCellPhone() {
		return candidateCellPhone;
	}
	public void setCandidateCellPhone(long candidateCellPhone) {
		this.candidateCellPhone = candidateCellPhone;
	}
	
	@Column(name="candidate_personal_phone")
	public long getCandidatePersonalPhone() {
		return candidatePersonalPhone;
	}
	public void setCandidatePersonalPhone(long candidatePersonalPhone) {
		this.candidatePersonalPhone = candidatePersonalPhone;
	}
	
	@Column(name="candidate_email")
	public String getCandidateEmail() {
		return candidateEmail;
	}
	public void setCandidateEmail(String candidateEmail) {
		this.candidateEmail = candidateEmail;
	}
	
	@Column(name="candidate_father_name")
	public String getCandidateFatherName() {
		return candidateFatherName;
	}
	public void setCandidateFatherName(String candidateFatherName) {
		this.candidateFatherName = candidateFatherName;
	}
	
	@Column(name="candidate_mother_name")
	public String getCandidateMotherName() {
		return candidateMotherName;
	}
	public void setCandidateMotherName(String candidateMotherName) {
		this.candidateMotherName = candidateMotherName;
	}
	
	@Column(name="candidate_mother_occupation")
	public String getCandidateMotherOccupation() {
		return candidateMotherOccupation;
	}
	public void setCandidateMotherOccupation(String candidateMotherOccupation) {
		this.candidateMotherOccupation = candidateMotherOccupation;
	}
	
	@Column(name="candidate_father_occupation")
	public String getCandidateFatherOccupation() {
		return candidateFatherOccupation;
	}
	public void setCandidateFatherOccupation(String candidateFatherOccupation) {
		this.candidateFatherOccupation = candidateFatherOccupation;
	}
	
	@Column(name="candidate_mother_phone")
	public long getCandidateMotherPhone() {
		return candidateMotherPhone;
	}
	public void setCandidateMotherPhone(long candidateMotherPhone) {
		this.candidateMotherPhone = candidateMotherPhone;
	}
	
	@Column(name="candidate_father_phone")
	public long getCandidateFatherPhone() {
		return candidateFatherPhone;
	}
	public void setCandidateFatherPhone(long candidateFatherPhone) {
		this.candidateFatherPhone = candidateFatherPhone;
	}
	
	@Column(name="candidate_middle_school_name")
	public String getCandidateMiddleSchool() {
		return candidateMiddleSchool;
	}
	public void setCandidateMiddleSchool(String candidateMiddleSchool) {
		this.candidateMiddleSchool = candidateMiddleSchool;
	}
	
	@Column(name="candidate_municipality_school")
	public String getCandidateMunicipalitySchool() {
		return candidateMunicipalitySchool;
	}
	public void setCandidateMunicipalitySchool(String candidateMunicipalitySchool) {
		this.candidateMunicipalitySchool = candidateMunicipalitySchool;
	}
	
	@Column(name="candidate_state_school")
	public String getCandidateStateSchool() {
		return candidateStateSchool;
	}
	public void setCandidateStateSchool(String candidateStateSchool) {
		this.candidateStateSchool = candidateStateSchool;
	}
	
	@Column(name="candidate_school_type")
	public String getCandidateSchoolType() {
		return candidateSchoolType;
	}
	public void setCandidateSchoolType(String candidateSchoolType) {
		this.candidateSchoolType = candidateSchoolType;
	}
	
	@Column(name="candidate_school_regime")
	public String getCandidateSchoolRegime() {
		return candidateSchoolRegime;
	}
	public void setCandidateSchoolRegime(String candidateSchoolRegime) {
		this.candidateSchoolRegime = candidateSchoolRegime;
	}
	
	@Column(name="candidate_school_key")
	public String getCandidateSchoolKey() {
		return candidateSchoolKey;
	}
	public void setCandidateSchoolKey(String candidateSchoolKey) {
		this.candidateSchoolKey = candidateSchoolKey;
	}
	
	@Column(name="candidate_school_enddate")
	public Date getCandidateEndDate() {
		return candidateEndDate;
	}
	public void setCandidateEndDate(Date candidateEndDate) {
		this.candidateEndDate = candidateEndDate;
	}
	
	@Column(name="candidate_shift")
	public String getCandidateShift() {
		return candidateShift;
	}

	public void setCandidateShift(String candidateShift) {
		this.candidateShift = candidateShift;
	}

	@Column(name="candidate_score")
	public int getCandidateScore() {
		return candidateScore;
	}
	public void setCandidateScore(int candidateScore) {
		this.candidateScore = candidateScore;
	}
	
	@Column( name="candidate_group" )
	public String getCandidateGroup() {
		return candidateGroup;
	}

	public void setCandidateGroup(String candidateGroup) {
		this.candidateGroup = candidateGroup;
	}

	@Column( name="candidate_creation_date" )
	public Date getCandidateCreationDate() {
		return candidateCreationDate;
	}

	public void setCandidateCreationDate(Date candidateCreationDate) {
		this.candidateCreationDate = candidateCreationDate;
	}

	@OneToOne (cascade = CascadeType.ALL)
	@JoinColumn(name="id_health")
	public Health getHealth() {
		return health;
	}
	public void setHealth(Health health) {
		this.health = health;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_preferences")
	public Preference getPreference() {
		return preference;
	}
	public void setPreference(Preference preference) {
		this.preference = preference;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_economy")
	public Economy getEconomy() {
		return economy;
	}
	public void setEconomy(Economy economy) {
		this.economy = economy;
	}

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="id_specialty")
	public Specialty getSpecialty() {
		return specialty;
	}

	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}
	
}
