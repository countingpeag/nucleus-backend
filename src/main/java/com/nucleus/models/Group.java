package com.nucleus.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="groups")
public class Group {
	
	private int idGroup;
	private String groupName;
	
	public Group() {		
	}
	
	public Group(String groupName) {
		this.groupName = groupName;
	}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_groups")
	public int getIdGroup() {
		return idGroup;
	}

	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
	}

	@Column(name="group_name")
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
}
