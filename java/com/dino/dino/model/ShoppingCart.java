package com.dino.dino.model;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
private int orderId ;
private List<Product> cartItem;
private CustomerDetails customerDetails;
private Double tot;



public int getOrderId() {
	return orderId;
}

public void setOrderId(int orderId) {
	this.orderId = new Random().nextInt(7);
}

public List<Product> getCartItem() {
	return cartItem;
}

public void setCartItem(List<Product> cartItem) {
	this.cartItem = cartItem;
}

public CustomerDetails getCustomerDetails() {
	return customerDetails;
}

public void setCustomerDetails(CustomerDetails customerDetails) {
	this.customerDetails = customerDetails;
}



	public Double getTot() {
	return tot;
}

public void setTot(Double tot) {
	this.tot = tot;
}

@Override
public String toString() {
	return "ShoppingCart [orderId=" + orderId + ", cartItem=" + cartItem + ", customerDetails=" + customerDetails
			+ ", tot=" + tot + ", getOrderId()=" + getOrderId() + ", getCartItem()=" + getCartItem()
			+ ", getCustomerDetails()=" + getCustomerDetails() + ", getTot()=" + getTot() + ", getClass()=" + getClass()
			+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}

	
}
