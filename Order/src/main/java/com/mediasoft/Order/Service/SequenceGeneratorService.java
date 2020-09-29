package com.mediasoft.Order.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;


import org.springframework.stereotype.Service;

import com.mediasoft.Order.Entity.Order;

@Service
public class SequenceGeneratorService {

	
	 @Autowired
	    MongoTemplate mongoTemplate;

    public long getMaxEmpId() {
        Query query = new Query();
        // List  fld_list = new ArrayList();
        // fld_list.add("id");
        // Sort  sort_cri = new Sort(fld_list);// (Sort.Direction.DESC, fld_list);
        query.with(Sort.by(Sort.Direction.DESC, "_id"));
        
        // query.with(new Sort().by(Sort.Direction.DESC, "id"));
        
        query.limit(1);
        Order maxObject = mongoTemplate.findOne(query, Order.class);
        if (maxObject == null) {
            return 0L;
        }
        return maxObject.getId();
    }
}
