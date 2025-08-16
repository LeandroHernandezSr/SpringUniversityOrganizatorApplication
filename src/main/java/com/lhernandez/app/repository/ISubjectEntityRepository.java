package com.lhernandez.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lhernandez.app.entities.SubjectEntity;

public interface ISubjectEntityRepository extends MongoRepository<SubjectEntity, String>{

}
