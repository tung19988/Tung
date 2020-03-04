package com.mediasoft.Order.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Promotion")
public class Promotion {
	@Id
    private long id;

	private String promotion_type;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPromotion_type() {
		return promotion_type;
	}

	public void setPromotion_type(String promotion_type) {
		this.promotion_type = promotion_type;
	}
	
	
    
}
