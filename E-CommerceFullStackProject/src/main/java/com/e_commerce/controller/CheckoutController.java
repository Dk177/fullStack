package com.e_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.e_commerce.dto.Purchase;
import com.e_commerce.dto.PurchaseResponse;
import com.e_commerce.service.CheckOutServiceImpl;

@CrossOrigin("http://localhost:4200")
@RestController
public class CheckoutController {

	@Autowired
	private CheckOutServiceImpl service;
	
	
	@PostMapping("/checkout/purchase")
	public PurchaseResponse addOrder(@RequestBody Purchase purchase) {
		return service.placeOrder(purchase);
	}
}
