package com.doodleblue.productservice.entity;

//import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
//import jakarta.persistence.Transient;

@Entity
@Table(name="product")
public class Product   {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long productId;
	private String productName;
	private long quantity;

	@OneToMany(mappedBy = "product",fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Order> order;
	
	public long getProductId() {
		return productId;
	}
	public String getProductName() {
		return productName;
	}
	public long getQuantity() {
		return quantity;
	}
	
	
	public Set<Order> getOrder() {
		return order;
	}
	public void setOrder(Set<Order> order) {
		this.order = order;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	} 
	public Product() {
		super();
	}
	public Product(String productName, long quantity) {
		super();
		this.productName = productName;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", quantity=" + quantity + "]";
	}
}
