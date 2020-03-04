package com.mediasoft.Order.Entity;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;


public class Goods {
	
	@DBRef
	private Shop_Product shopProduct_id;

	@DBRef
	private Variants variant_id;
    
	private String price;
	
	private long real_price;

	public Shop_Product getShopProduct_id() {
		return shopProduct_id;
	}

	public void setShopProduct_id(Shop_Product shopProduct_id) {
		this.shopProduct_id = shopProduct_id;
	}

	public Variants getVariant_id() {
		return variant_id;
	}

	public void setVariant_id(Variants variant_id) {
		this.variant_id = variant_id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public long getReal_price() {
		return real_price;
	}

	public void setReal_price(long real_price) {
		this.real_price = real_price;
	}
	
	
	
	
}
