package com.dino.dino.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
  
private List<Product> cartItem;
private CustomerDetails customerDetails;

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

	@Override
	public String toString() {
		return "ShoppingCart{" +
				"cartItem=" + cartItem +
				", customerDetails=" + customerDetails +
				'}';
	}
}
