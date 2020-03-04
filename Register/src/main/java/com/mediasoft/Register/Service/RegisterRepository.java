package com.mediasoft.Register.Service;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mediasoft.Register.Entity.Register;

public interface RegisterRepository extends MongoRepository<Register, Long> {
	Register findByid(Long id);
	Register findBytoken(Long token);
//	Register findBytokenid(Long tokenid);
//	Register findByUsername(String username);

//	void put(long id, Register re);
}
