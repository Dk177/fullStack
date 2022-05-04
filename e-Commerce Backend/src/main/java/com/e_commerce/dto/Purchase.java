package com.e_commerce.dto;

import java.util.Set;

import com.e_commerce.entity.Address;
import com.e_commerce.entity.Customer;
import com.e_commerce.entity.Order;
import com.e_commerce.entity.OrderItem;

public class Purchase {

	private Customer customer;
	
	private Address address;
	
	private Order  order;
	
	private Set<OrderItem> orderItems;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Purchase() {
		super();
	}

	public Purchase(Customer customer, Address address, Order order, Set<OrderItem> orderItems) {
		super();
		this.customer = customer;
		this.address = address;
		this.order = order;
		this.orderItems = orderItems;
	}
	
	
}
