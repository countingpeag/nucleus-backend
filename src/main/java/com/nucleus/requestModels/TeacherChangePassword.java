package com.nucleus.requestModels;

public class TeacherChangePassword {
	
	private int teacherId;
	private String newTeacherPassword;
	private String oldTeacherPassword;
	
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getNewTeacherPassword() {
		return newTeacherPassword;
	}
	public void setNewTeacherPassword(String newTeacherPassword) {
		this.newTeacherPassword = newTeacherPassword;
	}
	public String getOldTeacherPassword() {
		return oldTeacherPassword;
	}
	public void setOldTeacherPassword(String oldTeacherPassword) {
		this.oldTeacherPassword = oldTeacherPassword;
	}
	
}
