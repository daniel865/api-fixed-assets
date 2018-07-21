package com.co.intrasoft.fixedassets.repository;

import com.co.intrasoft.fixedassets.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "persons", path = "persons")
public interface PersonRepository extends MongoRepository<Person, String> {



}
