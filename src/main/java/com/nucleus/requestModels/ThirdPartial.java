package com.nucleus.requestModels;

public class ThirdPartial {
	private int approved;
	private int notApproved;
	private int man;
	private int women;
	
	public ThirdPartial() {}
	
	public ThirdPartial(int approved, int notApproved, int man, int women) {
		this.approved = approved;
		this.notApproved = notApproved;
		this.man = man;
		this.women = women;
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

	public int getMan() {
		return man;
	}

	public void setMan(int man) {
		this.man = man;
	}

	public int getWomen() {
		return women;
	}

	public void setWomen(int women) {
		this.women = women;
	}
}
