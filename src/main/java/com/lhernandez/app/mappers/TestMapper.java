package com.lhernandez.app.mappers;

import org.springframework.stereotype.Component;

import com.lhernandez.app.dto.TestDto;
import com.lhernandez.app.entities.TestEntity;
import com.lhernandez.app.models.test.Test;

@Component
public class TestMapper {
	
	private final SubjectMapper subjectMapper;
	
	private TestMapper(SubjectMapper subjectMapper) {
		this.subjectMapper=subjectMapper;
	}
	
	public Test toModel(TestEntity testEntity) {
		Test test=new Test();
		test.setId(testEntity.getId());
		test.setDate(testEntity.getDate());
		test.setName(testEntity.getName());
		test.setPoints(testEntity.getPoints());
		test.setSubject(subjectMapper.toModel(testEntity.getSubject()));
		return test;
	}
	
	public TestEntity toEntity(Test test) {
		TestEntity testEntity=new TestEntity();
		testEntity.setId(test.getId());
		testEntity.setName(test.getName());
		testEntity.setDate(test.getDate());
		testEntity.setPoints(test.getPoints());
		testEntity.setSubject(subjectMapper.toEntity(test.getSubject()));
		return testEntity;
	}
	
	public Test dtoToModel(TestDto dto) {
		Test test=new Test();
		test.setDate(dto.getDate());
		test.setId(dto.getId() != null ? dto.getId() : null);
		test.setName(dto.getName());
		test.setPoints(dto.getPoints());
		test.setSubject(subjectMapper.dtoToModel(dto.getSubject()));
		return test;
	}
	
	public TestDto ModelToDto(Test test) {
		TestDto dto=new TestDto();
		dto.setDate(test.getDate());
		dto.setId(test.getId() != null ? test.getId() : null);
		dto.setName(test.getName());
		dto.setPoints(test.getPoints());
		dto.setSubject(subjectMapper.modelToDto(test.getSubject()));
		return dto;
	}
}
