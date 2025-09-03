package com.lhernandez.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lhernandez.app.mappers.TestMapper;
import com.lhernandez.app.models.test.Test;
import com.lhernandez.app.repository.ITestEntityRepository;

@Service
public class TestServiceImpl implements ITestService{

	private final TestMapper mapper;
	private final ITestEntityRepository repository;
	
	public TestServiceImpl(TestMapper mapper,ITestEntityRepository repository) {
		this.mapper=mapper;
		this.repository=repository;
	}
	
	@Override
	public Test create(Test test) {
		return this.mapper.toModel(this.repository.save(this.mapper.toEntity(test)));
	}

	@Override
	public void delete(Test test) {
		this.repository.delete(this.mapper.toEntity(test));
	}

	@Override
	public Test update(Test test) {
		return this.mapper.toModel(this.repository.save(this.mapper.toEntity(test)));
	}

	@Override
	public Optional<Test> getById(String id) {
		return this.repository.findById(id).map(mapper::toModel);
	}

	@Override
	public List<Test> getAllTests() {
		return this.repository.findAll().stream().map(mapper::toModel).toList();
	}

}
