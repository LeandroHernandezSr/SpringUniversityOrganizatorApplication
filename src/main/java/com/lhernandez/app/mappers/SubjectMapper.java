package com.lhernandez.app.mappers;

import org.springframework.stereotype.Component;

import com.lhernandez.app.entities.SubjectEntity;
import com.lhernandez.app.models.subjects.Subject;

@Component
public class SubjectMapper {
	
	public Subject toModel(SubjectEntity subjectEntity) {
		Subject subject=new Subject();
		subject.setId(subjectEntity.getId());
		subject.setName(subjectEntity.getName());
		subject.setPracticalDays(subjectEntity.getPracticalDays());
		subject.setTheoricalDays(subjectEntity.getTheoricalDays());
		return subject;
	}
	
	public SubjectEntity toEntity(Subject subject) {
		SubjectEntity subjectEntity=new SubjectEntity();
		subject.setId(subject.getId());
		subjectEntity.setName(subject.getName());
		subjectEntity.setPracticalDays(subject.getPracticalDays());
		subjectEntity.setTheoricalDays(subject.getTheoricalDays());
		return subjectEntity;
	}
	
}
