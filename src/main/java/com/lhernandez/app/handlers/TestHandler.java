package com.lhernandez.app.handlers;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.lhernandez.app.dto.TestDto;
import com.lhernandez.app.mappers.TestMapper;
import com.lhernandez.app.services.ITestService;

@Component
public class TestHandler {
	
	private final ITestService service;
	private final TestMapper mapper;
	
	public TestHandler(ITestService service,TestMapper mapper) {
		this.service=service;
		this.mapper=mapper;
	}
	
	public Optional<TestDto>create(TestDto dto){
		return Optional.of(dto)
				.map(mapper::dtoToModel)
				.map(service::create)
				.map(mapper::ModelToDto);
	}
	
	public void delete(TestDto dto) {
		this.service.delete(mapper.dtoToModel(dto));
	}
	
	public Optional<TestDto>update(TestDto dto){
		return Optional.of(dto)
				.map(mapper::dtoToModel)
				.map(service::update)
				.map(mapper::ModelToDto);
	}
	
	public Optional<TestDto>getById(String id){
		return this.service.getById(id).map(mapper::ModelToDto);
	}
	
}
