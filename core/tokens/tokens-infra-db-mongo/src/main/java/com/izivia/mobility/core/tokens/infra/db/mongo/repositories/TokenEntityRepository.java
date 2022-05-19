package com.izivia.mobility.core.tokens.infra.db.mongo.repositories;

import com.izivia.mobility.core.tokens.infra.db.mongo.entities.TokenEntity;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenEntityRepository extends MongoRepository<TokenEntity, String> {

  Optional<TokenEntity> findByUuid(String uuid);

}
