package com.mitchell.automobileservice.model;

import javax.validation.constraints.*;

public class Vehicle {
	//Validation for the properties 
	@NotNull(message = "Vehicle Id can not be null")
	private Integer id;
	
	@Min(value = 1950, message = "Vehicle Year can not be less than 1950")
	@Max(value = 2050, message = "Vehicle Year can not be greater than 2050")
	private Integer year;
	
	@NotNull(message = "Make of the vehicle can not be null")
	private String make;
	
	@NotNull(message = "Model of the vehicle can not be null")
	private String model;
	
	public Vehicle() {
		super();
	}
	
	public Vehicle(int id, int year, String make, String model) {
		super();
		this.id = id;
		this.year = year;
		this.make = make;
		this.model = model;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}	
}
