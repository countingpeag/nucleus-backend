package com.nucleus.requestModels;

public class DataStatistics {

	private int approved;
	private int notApproved;
	private int men;
	private int women;
	private FirstPartial firstP;
	private SecondPartial SecondP;
	private ThirdPartial ThirdP;
	
	public DataStatistics() {}
	
	public DataStatistics(int approved, int notApproved, int men, int women, FirstPartial firstP, SecondPartial secondP,
			ThirdPartial thirdP) {
		this.approved = approved;
		this.notApproved = notApproved;
		this.men = men;
		this.women = women;
		this.firstP = firstP;
		SecondP = secondP;
		ThirdP = thirdP;
	}
	
	public int getApproved() {
		return approved;
	}
	public void setApproved(int approved) {
		this.approved = approved;
	}
	public int getNotApproved() {
		return notApproved;
	}
	public void setNotApproved(int notApproved) {
		this.notApproved = notApproved;
	}
	public int getMen() {
		return men;
	}
	public void setMen(int men) {
		this.men = men;
	}
	public int getWomen() {
		return women;
	}
	public void setWomen(int women) {
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
