package com.lhernandez.app.dto;

import java.util.List;

import com.lhernandez.app.models.Days;

public class SubjectDto {
	
	private String id;
	private String name;
	private List<Days>practicalDays;
	private List<Days>theoricalDays;
	
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
	
	public List<Days> getPracticalDays() {
		return practicalDays;
	}
	
	public void setPracticalDays(List<Days> practicalDays) {
		this.practicalDays = practicalDays;
	}
	
	public List<Days> getTheoricalDays() {
		return theoricalDays;
	}
	
	public void setTheoricalDays(List<Days> theoricalDays) {
		this.theoricalDays = theoricalDays;
	}
	
	
}
