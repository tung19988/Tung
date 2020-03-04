package com.mediasoft.Register.dao;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mediasoft.Register.Entity.Register;
import com.mediasoft.Register.Service.RegisterRepository;

@Service
public class TokenidDao {
	
	RegisterRepository res;
	
	MongoTemplate mong;
	
//	public Register save(Role tk) {
//		Register newUser = new Register();
//		newUser.setid(tk.get_id());
//		newUser.setToken_id(tk.getToken_id());
//		return res.save(newUser);
//	}
	
	public void updateQuery(long token) {
		 Query query1 = new Query(Criteria.where("token_id").is(token));
         Update update1 = new Update();
         update1.set("token_id", 0);
         mong.updateFirst(query1, update1, Register.class);
	}
}
