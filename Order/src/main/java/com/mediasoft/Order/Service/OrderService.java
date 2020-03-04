package com.mediasoft.Order.Service;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.mediasoft.Order.Entity.Order;
import com.mediasoft.Order.Entity.SalesReport;

@Service
public class OrderService {
	@Autowired
    OrderPageRepo repository;
	
	@Autowired
	 MongoTemplate mongoTemplate;
     
    public List<Order> getAllOrder(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
 
        Page<Order> pagedResult = repository.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Order>();
        }
    }
    
    @Autowired
    private MongoOperations mongoOperations;

    public Page<Order> searchCustom(Integer pageNo, Integer pageSize, String sortBy) {
    	
    	Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        Query query = new Query().with(paging);
        // Build your query here

        List<Order> list = mongoOperations.find(query, Order.class);
        long count = mongoOperations.count(query, Order.class);
        Page<Order> resultPage = new PageImpl<Order>(list , paging, count);
        return resultPage;
    }
    
    public List<Order> getdate(String fromDate,String toDate) throws ParseException {
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    	LocalDate startDate,endDate;

    	startDate =  LocalDate.parse(fromDate, formatter);
    	endDate = LocalDate.parse(toDate, formatter);
    	Query query = new Query();
//    	Query q = new Query().addCriteria(new Criteria().orOperator(
//    	          new Criteria().andOperator(Criteria.where("orderDate").gte(startDate),
//    	          Criteria.where("orderDate").lte(endDate)),
//    	          new Criteria().andOperator(Criteria.where("orderDate").gte(startDate),
//    	          Criteria.where("orderDate").lte(endDate))
//    	        ));
    	
    	query.addCriteria(Criteria.where("orderDate").gte(startDate).lte(endDate));
		
    	List<Order> result= mongoTemplate.find(query, Order.class);
    	
		return result;
	}
    
public List<SalesReport> gettotal() {
	
	Aggregation aggregation = newAggregation(group("goods.shopProduct_id.seller_id")
			.sum("goods.real_price").as("total")
			.addToSet("goods.shopProduct_id.seller_id").as("seller_id"),
			sort(Sort.Direction.ASC, previousOperation(), "total"));

	AggregationResults<SalesReport> groupResults = mongoTemplate.aggregate(
			aggregation, Order.class,SalesReport.class);

	List<SalesReport> salesReport = groupResults.getMappedResults();

	return salesReport;
	}
    
}
