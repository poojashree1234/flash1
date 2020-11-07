package com.model;

public class View {
	private String id;
	private String brand;
	private String color;
	private String price;
private String name;
private String password;
	public View() {
	// TODO Auto-generated constructor stub
	}


	public String getId() {
	return id;
	}

	public void setId(String id) {
	this.id = id;
	}

	
	public String getBrand() {
	return brand;
	}

	public void setBrand(String brand) {
	this.brand = brand;
	}

	public String getColor() {
	return color;
	}


	public void setColor(String color) {
	this.color = color;
	}


	public String getPrice() {
	return price;
	}

	public void setPrice(String price) {
	this.price = price;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public View(String id, String brand, String color, String price,String name,String password) {
	super();
	this.id = id;
	this.brand = brand;
	this.color = color;
	this.price = price;
	this.name=name;
	this.password=password;
	
	}

	}

