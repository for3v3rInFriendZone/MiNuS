package com.minus.www.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMMENT")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "SENDERNAME")
	private String senderName;

	@Column(name = "SENDEREMAIL")
	private String senderEmail;

	@Column(name = "SENDERCOMMENT")
	private String senderComment;

	public Comment() {

	}

	public Comment(String senderName, String senderEmail, String senderComment) {
		super();
		this.senderName = senderName;
		this.senderEmail = senderEmail;
		this.senderComment = senderComment;
	}

	public Long getId() {
		return id;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderEmail() {
		return senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}

	public String getSenderComment() {
		return senderComment;
	}

	public void setSenderComment(String senderComment) {
		this.senderComment = senderComment;
	}

}
