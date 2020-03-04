package com.mediasoft.Order.Entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Order")
public class Order {

	@Transient
    public static final String SEQUENCE_NAME = "order";
	
	@Id
    private long id;
	
	private Goods goods;
	
	@DBRef
	private Promotion promotion_type;
	
	private String promotion_code;
	
	@DBRef
	private Pay pay;

	private Integer receiving_phone;
    
	private ReceivingAddress receiving_address;
	
	@DBRef
	private Shipper shipper;
	
	private LocalDate orderDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Promotion getPromotion_type() {
		return promotion_type;
	}

	public void setPromotion_type(Promotion promotion_type) {
		this.promotion_type = promotion_type;
	}
	
	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getPromotion_code() {
		return promotion_code;
	}

	public void setPromotion_code(String promotion_code) {
		this.promotion_code = promotion_code;
	}

	public Pay getPay() {
		return pay;
	}

	public void setPay(Pay pay) {
		this.pay = pay;
	}

	public Integer getReceiving_phone() {
		return receiving_phone;
	}

	public void setReceiving_phone(Integer receiving_phone) {
		this.receiving_phone = receiving_phone;
	}

	public ReceivingAddress getReceiving_address() {
		return receiving_address;
	}

	public void setReceiving_address(ReceivingAddress receiving_address) {
		this.receiving_address = receiving_address;
	}

	public Shipper getShipper() {
		return shipper;
	}

	public void setShipper(Shipper shipper) {
		this.shipper = shipper;
	}

	public Order(long id, Goods goods, Promotion promotion_type, String promotion_code, Pay pay,
			Integer receiving_phone, ReceivingAddress receiving_address, Shipper shipper) {
		super();
		this.id = id;
		this.goods = goods;
		this.promotion_type = promotion_type;
		this.promotion_code = promotion_code;
		this.pay = pay;
		this.receiving_phone = receiving_phone;
		this.receiving_address = receiving_address;
		this.shipper = shipper;
	}

	public Order() {
		super();
	} 
	

}
