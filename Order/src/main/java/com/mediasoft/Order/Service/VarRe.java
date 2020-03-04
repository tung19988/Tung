package com.mediasoft.Order.Service;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mediasoft.Order.Entity.Variants;

public interface VarRe extends MongoRepository<Variants, Long>{

}
