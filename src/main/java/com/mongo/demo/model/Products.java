package com.mongo.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Document("product")
public class Products {

	@Id
	String id;
	@Field(name = "name")
	String name;
	@Field(name = "desciption")
	String desciption;
	@Field(name = "category")
	String category;
	@Field(name = "image")
	String image;
	@Field(name = "rating")
	Rating rating;
	@Field(name = "price")
	int price;
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Products(String id, String name, String desciption, int price) {
		super();
		this.id = id;
		this.name = name;
		this.desciption = desciption;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesciption() {
		return desciption;
	}
	public String getId() {
		return id;
	}
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Rating getRating() {
		return rating;
	}
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	public void setId(String id) {
		this.id = id;
	}	
	
	
}
