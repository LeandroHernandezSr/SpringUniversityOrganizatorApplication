package com.lhernandez.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lhernandez.app.entities.TestEntity;

public interface ITestEntityRepository extends MongoRepository<TestEntity,String>{

}
