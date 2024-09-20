package com.retail.discount.impl;

import com.retail.discount.calculate.Discount;
import com.retail.discount.service.Bill;

/**
 * This class will called when no percentage based discount condition will be
 * match.
 */
public class NoDiscount implements Discount {

	@Override
	public Bill applyDiscount(Bill bill) {
		bill.getItems().stream().forEach(item -> {
			item.setDiscountedPrice(item.getPrice());
		});
		return bill;
	}

}
