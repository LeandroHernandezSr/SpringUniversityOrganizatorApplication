package com.lhernandez.app.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "tests")
public class TestEntity {
	
	@Id
	private String id;
	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	private Double points;
	private SubjectEntity subject;
	
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
	
	public SubjectEntity getSubject() {
		return subject;
	}
	
	public void setSubject(SubjectEntity subject) {
		this.subject = subject;
	}
	
}
