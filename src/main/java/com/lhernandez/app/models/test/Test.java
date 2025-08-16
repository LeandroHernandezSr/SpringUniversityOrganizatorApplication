package com.lhernandez.app.models.test;

import java.util.Date;

import com.lhernandez.app.models.subjects.Subject;

public class Test {
	
	private String id;
	private String name;
	private Date date;
	private Double points;
	private Subject subject;
	
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
	
	public Subject getSubject() {
		return subject;
	}
	
	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
