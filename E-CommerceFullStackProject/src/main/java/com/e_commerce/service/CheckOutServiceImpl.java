package com.e_commerce.service;

import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_commerce.dto.Purchase;
import com.e_commerce.dto.PurchaseResponse;
import com.e_commerce.entity.Customer;
import com.e_commerce.entity.Order;
import com.e_commerce.entity.OrderItem;
import com.e_commerce.repository.CustomerRepository;

@Service
public class CheckOutServiceImpl implements CheckOutService {
	
	@Autowired
	private CustomerRepository customerRepo;

	@Override
	@Transactional
	public PurchaseResponse placeOrder(Purchase purchase) {

		// retrieve order from dto
		Order order = purchase.getOrder();
		
		// generate tracking Number
		String trackingNo = generateTrackingNumber();
		order.setOrderTrackingNumber(trackingNo);
		
		// populate order with order Items
		Set<OrderItem> orderItems = purchase.getOrderItems();
		for(OrderItem item:orderItems) {
			order.add(item);
		}
		
		//populate order with billing Address
		order.setAddress(purchase.getAddress());
		
		// populate Customer with order
		Customer customer = purchase.getCustomer();
		customer.add(order);
		
		//save to database
		customerRepo.save(customer);
		
		return new PurchaseResponse(trackingNo);
	}

	private String generateTrackingNumber() {

		return UUID.randomUUID().toString();
	}
	
	
}
