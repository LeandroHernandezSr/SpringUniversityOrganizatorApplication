package com.lhernandez.app.mappers;

import org.springframework.stereotype.Component;

import com.lhernandez.app.dto.SubjectDto;
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
	
	public SubjectDto modelToDto(Subject subject) {
		SubjectDto dto=new SubjectDto();
		dto.setId(subject.getId());
		dto.setName(subject.getName());
		dto.setPracticalDays(subject.getPracticalDays());
		dto.setTheoricalDays(subject.getTheoricalDays());
		return dto;
	}
	
	public Subject dtoToModel(SubjectDto dto) {
		Subject subject=new Subject();
		subject.setId(dto.getId());
		subject.setName(dto.getName());
		subject.setPracticalDays(dto.getPracticalDays());
		subject.setTheoricalDays(dto.getTheoricalDays());
		return subject;
	}
	
}
