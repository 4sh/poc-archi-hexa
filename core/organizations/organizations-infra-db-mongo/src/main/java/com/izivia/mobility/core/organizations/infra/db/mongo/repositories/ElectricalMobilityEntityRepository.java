package com.izivia.mobility.core.organizations.infra.db.mongo.repositories;

import com.izivia.mobility.core.organizations.infra.db.mongo.entities.ElectricalMobilityEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectricalMobilityEntityRepository extends MongoRepository<ElectricalMobilityEntity, String> {

}
