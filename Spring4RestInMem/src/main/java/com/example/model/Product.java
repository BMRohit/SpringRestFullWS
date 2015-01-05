/**
 * 
 */
package com.example.model;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Rohit
 *
 */

public class Product 
{
	
	private long productID;
	private String productName;
	private double price;
	
	private byte[] image;
	
	
	public Product() {
	}

	public Product(long productID, String productName, double price) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.price = price;
		
	}

	
	
	
	public Product(long productID, String productName, double price,
			byte[] image) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.price = price;
		this.image = image;
	}

	public long getProductID() {
		return productID;
	}

	public void setProductID(long productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	@JsonIgnore
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productName="
				+ productName + ", price=" + price + ", image="
				+ Arrays.toString(image) + "]";
	}
	
	
}
