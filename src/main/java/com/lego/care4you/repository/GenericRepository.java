package com.lego.care4you.repository;

import com.lego.care4you.domain.DomainBase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface GenericRepository<T extends DomainBase> extends MongoRepository<T, String> {

    @Query("{ 'id' : ?0 }")
    T findOne(String id);
}
