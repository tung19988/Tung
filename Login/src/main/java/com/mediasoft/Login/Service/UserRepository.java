package com.mediasoft.Login.Service;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mediasoft.Login.Entity.DAOUser;



public interface UserRepository extends MongoRepository<DAOUser, Integer> {
	
	DAOUser findByUser(String user);
	DAOUser findByPass(String pass);
	
	@Query("{user:'?0'}")
    boolean findCustomByUser(String user);
//	DAOUser findByUserLike(String user);
//	DAOUser findByPassLike(String pass);
	
//	DAOUser findOne()
}