package com.example.AgricultureMarketSystem.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Merchant {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int merchant_id;
	private String full_name;
    private int price;
    private String mobile_number;
    private String username;
	
    public Merchant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Merchant(int merchant_id, String full_name, int price, String mobile_number, String username) {
		super();
		this.merchant_id = merchant_id;
		this.full_name = full_name;
		this.price = price;
		this.mobile_number = mobile_number;
		this.username = username;
	}

	public int getMerchant_id() {
		return merchant_id;
	}

	public void setMerchant_id(int merchant_id) {
		this.merchant_id = merchant_id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
   

}
