package com.lhernandez.app.handlers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.lhernandez.app.dto.SubjectDto;
import com.lhernandez.app.mappers.SubjectMapper;
import com.lhernandez.app.services.ISubjectService;

@Component
public class SubjectHandler {
	
	private final ISubjectService service;
	private final SubjectMapper mapper;
	
	public SubjectHandler(ISubjectService service,SubjectMapper mapper) {
		this.service=service;
		this.mapper=mapper;
	}
	
	
	public SubjectDto create(SubjectDto dto) {
		return this.mapper.modelToDto(this.service.create(mapper.dtoToModel(dto)));
	}
	
	public Optional<SubjectDto> update(SubjectDto dto){
		return Optional.of(dto)
				.map(mapper::dtoToModel)
				.map(service::update)
				.map(mapper::modelToDto);
	}
	
	public Optional<SubjectDto>findById(String id){
		return this.service.findSubjectById(id).map(mapper::modelToDto);
	}
	
	public void deleteSubject(SubjectDto subject) {
		this.service.deleteSubject(mapper.dtoToModel(subject));
	}
	
	
	public List<SubjectDto>getAllSubjects(){
		return this.service.getAllSubjects().stream().map(mapper::modelToDto).toList();
	}
}
