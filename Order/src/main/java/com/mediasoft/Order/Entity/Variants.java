package com.mediasoft.Order.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Variants")
public class Variants {

	@Id
    private long id;
	
	public long product_id;
	
	public String image_default;
	
	public String sku;
	
	public int cost_suppler;
	@DBRef
	public Shipper shipp_id;
	
	public int price;
	
	public int compared_at_price;
	
	public int inventory;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}

	public String getImage_default() {
		return image_default;
	}

	public void setImage_default(String image_default) {
		this.image_default = image_default;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public int getCost_suppler() {
		return cost_suppler;
	}

	public void setCost_suppler(int cost_suppler) {
		this.cost_suppler = cost_suppler;
	}

	public Shipper getShipp_id() {
		return shipp_id;
	}

	public void setShipp_id(Shipper shipp_id) {
		this.shipp_id = shipp_id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCompared_at_price() {
		return compared_at_price;
	}

	public void setCompared_at_price(int compared_at_price) {
		this.compared_at_price = compared_at_price;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	
	
	
	
}
