package com.nucleus.requestModels;

public class DataStatistics {

	private Long approved;
	private Long notApproved;
	private Long men;
	private Long women;
	private FirstPartial firstP;
	private SecondPartial SecondP;
	private ThirdPartial ThirdP;
	
	public DataStatistics() {}
	
	public DataStatistics(Long approved, Long notApproved, Long men, Long women, FirstPartial firstP, SecondPartial secondP,
			ThirdPartial thirdP) {
		this.approved = approved;
		this.notApproved = notApproved;
		this.men = men;
		this.women = women;
		this.firstP = firstP;
		SecondP = secondP;
		ThirdP = thirdP;
	}
	
	public Long getApproved() {
		return approved;
	}
	public void setApproved(Long approved) {
		this.approved = approved;
	}
	public Long getNotApproved() {
		return notApproved;
	}
	public void setNotApproved(Long notApproved) {
		this.notApproved = notApproved;
	}
	public Long getMen() {
		return men;
	}
	public void setMen(Long men) {
		this.men = men;
	}
	public Long getWomen() {
		return women;
	}
	public void setWomen(Long women) {
		this.women = women;
	}

	public FirstPartial getFirstP() {
		return firstP;
	}

	public void setFirstP(FirstPartial firstP) {
		this.firstP = firstP;
	}

	public SecondPartial getSecondP() {
		return SecondP;
	}

	public void setSecondP(SecondPartial secondP) {
		SecondP = secondP;
	}

	public ThirdPartial getThirdP() {
		return ThirdP;
	}

	public void setThirdP(ThirdPartial thirdP) {
		ThirdP = thirdP;
	}
	
}
