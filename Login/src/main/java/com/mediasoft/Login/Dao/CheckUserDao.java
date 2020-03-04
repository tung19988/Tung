package com.mediasoft.Login.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.mediasoft.Login.Entity.DAOUser;

@Service
public class CheckUserDao {
	
	 @Autowired
	 MongoTemplate mongoTemplate;
	 
	 public boolean checkUser(String users) {
		 Query query = new Query();
		 query.addCriteria(Criteria.where("user").regex(users));
		 DAOUser user = mongoTemplate.findOne(query, DAOUser.class);
		
		 if(user != null) {
			return true;
			}
		return false;
	}
	 
	 public boolean checkPass(String pass) {
		 Query query = new Query();
		 query.addCriteria(Criteria.where("pass").regex(pass));
		 DAOUser user = mongoTemplate.findOne(query, DAOUser.class);
		
		 if(user != null) {
			return true;
			}
		return false;
	}
	 
	 public Integer getId(String user) {
		 Query query = new Query();
		 query.addCriteria(Criteria.where("user").regex(user));
		 DAOUser users = mongoTemplate.findOne(query, DAOUser.class);
		
		 if(user != null) {
			return users.getId();
			}
		return 0;
	}
	 
}
