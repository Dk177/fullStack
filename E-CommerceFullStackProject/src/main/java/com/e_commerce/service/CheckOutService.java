package com.e_commerce.service;

import com.e_commerce.dto.Purchase;
import com.e_commerce.dto.PurchaseResponse;

public interface CheckOutService {

	public PurchaseResponse placeOrder(Purchase purchase);
}
