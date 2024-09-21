package com.retail.discount.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.retail.discount.calculate.Discount;
import com.retail.discount.constant.Constants;
import com.retail.discount.entity.BillItem;
import com.retail.discount.model.User;

/**
 * CalculateDiscount used to calculate the discount on the bill based on the
 * below rules 1) If the user is an employee of the store, he gets a 30%
 * discount 2) If the user is an affiliate of the store, he gets a 10% discount
 * 3) If the user has been a customer for over 2 years, he gets a 5% discount.
 * 4) For every $100 on the bill, there would be a $ 5 discount. 5) The 5)
 * percentage based discounts do not apply on groceries. 6) A user can get only
 * one of the percentage based discounts on a bill.
 **/
@Service
public class CalculateDiscount {

	public Bill discountCalculation(Bill bill) throws IOException {

		/*
		 * Get required discount type object on the basis of type of customer
		 */
		Discount percentageDiscount = DiscountFactory.createDiscount(bill);

		User usr = bill.getUser();
		double i;
		if (bill.getItems().size() > 0 && usr.getUserType().equals(Constants.USER_TYPE_NEW_CUSTOMER)) {
			percentageDiscount.applyDiscount(bill);
			calculateAmount(bill);

			i = bill.getPayableAmount() - (Math.floor(bill.getPayableAmount() / 100) * 5);
			bill.setPayableAmount(i);
		} else {

			percentageDiscount.applyDiscount(bill);
			calculateAmount(bill);
		}

		return bill;
	}

	/*
	 * item separation if the item type is groceries then dont calculate the
	 * discount
	 */
	private void calculateAmount(Bill bill) {

		double payableAmount = 0.0;
		for (BillItem item : bill.getItems()) {
			payableAmount += item.getDiscountedPrice();
			item.setDiscountedPrice(item.getDiscountedPrice());
		}
		bill.setPayableAmount(payableAmount);
	}
}
