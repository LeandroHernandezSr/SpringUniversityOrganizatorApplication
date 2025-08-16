package com.lhernandez.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lhernandez.app.entities.StudentEntity;

public interface IStudentEntityRepository extends MongoRepository<StudentEntity, String>{

}
