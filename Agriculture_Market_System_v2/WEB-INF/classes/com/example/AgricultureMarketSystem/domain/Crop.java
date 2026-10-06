package com.example.AgricultureMarketSystem.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Crop {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
    private String crop_name;
    private int price;
    private int quantity;
    private int merchant_id;
    

	public Crop() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Crop(int id, String crop_name, int price, int quantity) {
		super();
		this.id = id;
		this.crop_name = crop_name;
		this.price = price;
		this.quantity = quantity;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCrop_name() {
		return crop_name;
	}


	public void setCrop_name(String crop_name) {
		this.crop_name = crop_name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getMerchant_id() {
		return merchant_id;
	}


	public void setMerchant_id(int merchant_id) {
		this.merchant_id = merchant_id;
	}

	
}
