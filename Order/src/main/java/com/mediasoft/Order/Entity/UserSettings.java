package com.mediasoft.Order.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Shop_Product")
public class Shop_Product {
	@Id
    private long id;
	
	private long seller_id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(long seller_id) {
		this.seller_id = seller_id;
	}
	
	
	
}
