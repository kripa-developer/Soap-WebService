package com.example.soapws.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name="ProductDetails")
public class Product {
	@Id
	@Column(name = "productId")
	private Long productId;

	@Column(name = "productName")
	private String productName;

	@Column(name = "stock")
	private Long stock;

	@Column(name = "expiryDate")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date expiryDate;

	@Column(name = "price")
	private Long price;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}
}
