package com.doodleblue.productservice.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

//import java.io.Serializable;

//import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="order_table")
public class Order {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private long orderId;
private long userId;
@ManyToOne
@JoinColumn(name = "product_id")
private Product product;
private long quantity;

public void setOrderId(long orderId) {
	this.orderId = orderId;
}
public long getOrderId() {
	return orderId;
}
public long getUserId() {
	return userId;
}
public void setUserId(long userId) {
	this.userId = userId;
}
public Product getProduct() {
	return product;
}
public void setProduct(Product productId) {
	this.product = productId;
}
public long getQuantity() {
	return quantity;
}
public void setQuantity(long quantity) {
	this.quantity = quantity;
}

public Order(long userId, Product productId, long quantity) {
	super();
	this.userId = userId;
	this.product = productId;
	this.quantity = quantity;
}
public Order() {
	super();
}
@Override
public String toString() {
	return "Order [orderId=" + orderId + ", userId=" + userId + ", productId=" + product + ", quantity=" + quantity
			+ "]";
}

}
