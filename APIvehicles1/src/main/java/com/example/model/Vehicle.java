package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicles")
public class Vehicle {

//	v_id bigint Not NUll auto_increment,
//	v_name varchar(50) default null,
//	v_price float default null,
//	v_mileage integer default null,
//	v_model varchar(50) default null,
//	primary key(v_id)
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long v_id;
	
	@Column(name="v_name")
	private String v_name;
	
	@Column(name="v_price")
	private Float v_price;
	
	@Column(name="v_mileage")
	private int v_mileage;
	
	@Column(name="v_model")
	private String v_model;

	public Long getV_id() {
		return v_id;
	}

	public void setV_id(Long v_id) {
		this.v_id = v_id;
	}

	public String getV_name() {
		return v_name;
	}

	public void setV_name(String v_name) {
		this.v_name = v_name;
	}

	public Float getV_price() {
		return v_price;
	}

	public void setV_price(Float v_price) {
		this.v_price = v_price;
	}

	public int getV_mileage() {
		return v_mileage;
	}

	public void setV_mileage(int v_mileage) {
		this.v_mileage = v_mileage;
	}

	public String getV_model() {
		return v_model;
	}

	public void setV_model(String v_model) {
		this.v_model = v_model;
	}

	public Vehicle(Long v_id, String v_name, Float v_price, int v_mileage, String v_model) {
		super();
		this.v_id = v_id;
		this.v_name = v_name;
		this.v_price = v_price;
		this.v_mileage = v_mileage;
		this.v_model = v_model;
	}
	
	public Vehicle() {
		
	}

	@Override
	public String toString() {
		return "Vehicle [v_id=" + v_id + ", v_name=" + v_name + ", v_price=" + v_price + ", v_mileage=" + v_mileage
				+ ", v_model=" + v_model + "]";
	}
	
	
}
