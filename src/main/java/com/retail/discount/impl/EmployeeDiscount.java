package com.retail.discount.impl;

import com.retail.discount.calculate.Discount;
import com.retail.discount.constant.Constants;
import com.retail.discount.service.Bill;

/**
 * This is a type of discount which will be applied when a the user is of type
 * employee.
 */
public class EmployeeDiscount implements Discount {

	@Override
	public Bill applyDiscount(Bill bill) {

		bill.getItems().stream().forEach(item -> {

			double discountedPrice = item.getPrice();
			// set discounted price of items when item is not a grocery item.
			if (!item.getItemType().equals(Constants.ITEM_TYPE_GROCERY)) {
				double discountAmount = item.getPrice() * Constants.EMPLOYEE_DISCOUNT_RATE;
				discountedPrice = item.getPrice() - discountAmount;
			}
			item.setDiscountedPrice(discountedPrice);
		});

		return bill;
	}
}
