package com.nucleus.requestModels;

public class ThirdPartial {
	private Long approved;
	private Long notApproved;
	private Long man;
	private Long women;
	
	public ThirdPartial() {}
	
	public ThirdPartial(Long approved, Long notApproved, Long man, Long women) {
		this.approved = approved;
		this.notApproved = notApproved;
		this.man = man;
		this.women = women;
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

	public Long getMan() {
		return man;
	}

	public void setMan(Long man) {
		this.man = man;
	}

	public Long getWomen() {
		return women;
	}

	public void setWomen(Long women) {
		this.women = women;
	}
}
