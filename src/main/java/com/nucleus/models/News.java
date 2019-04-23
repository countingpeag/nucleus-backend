package com.nucleus.models;

//import java.sql.Blob;
import java.util.Date;

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
@Table(name="news")
public class News {
	
	private int idNew;
	private String newContent;
	private String image;
	private Date date;
	private char priority;
	private Administrator administrator;
	
	public News() {}
	
	public News(int idNew) {
		this.idNew = idNew;
	}

	public News(String newContent, String  image, Date date, char priority, Administrator administrator) {
		this.newContent = newContent;
		this.image = image;
		this.date = date;
		this.priority = priority;
		this.administrator = administrator;
	}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_new")
	public int getIdNew() {
		return idNew;
	}

	public void setIdNew(int idNew) {
		this.idNew = idNew;
	}

	@Column(name="new_content")
	public String getNewContent() {
		return newContent;
	}

	public void setNewContent(String newContent) {
		this.newContent = newContent;
	}

	@Column(name="image")
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name="date")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name="priority")
	public char getPriority() {
		return priority;
	}

	public void setPriority(char priority) {
		this.priority = priority;
	}

	@ManyToOne
	@JoinColumn(name="ADMINISTRATORS_id_administrator", foreignKey=@ForeignKey(name="id_administrator"))
	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}
}
