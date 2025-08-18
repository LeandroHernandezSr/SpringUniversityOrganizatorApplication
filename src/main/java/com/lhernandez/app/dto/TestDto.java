package com.lhernandez.app.dto;

import java.util.Date;

public class TestDto {

	private String id;
	private String name;
	private Date date;
	private Double points;
	private SubjectDto subject;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Double getPoints() {
		return points;
	}
	
	public void setPoints(Double points) {
		this.points = points;
	}
	
	public SubjectDto getSubject() {
		return subject;
	}
	
	public void setSubject(SubjectDto subject) {
		this.subject = subject;
	}
	
	
}
