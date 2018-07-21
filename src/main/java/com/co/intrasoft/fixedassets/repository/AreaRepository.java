package com.co.intrasoft.fixedassets.repository;

import com.co.intrasoft.fixedassets.model.Area;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "areas", path = "areas")
public interface AreaRepository extends MongoRepository<Area, String> {

    Optional<Area> findByCity(String city);
}
