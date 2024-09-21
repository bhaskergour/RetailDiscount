package com.retail.discount.service;

import com.retail.discount.calculate.Discount;
import com.retail.discount.constant.Constants;
import com.retail.discount.impl.AffiliateDiscount;
import com.retail.discount.impl.CustomerDiscount;
import com.retail.discount.impl.EmployeeDiscount;
import com.retail.discount.impl.NoDiscount;
import com.retail.discount.model.User;
import com.retail.discount.utility.DateCompare;

/**
 * Factory class to generate discount type objects on the basis of user type.
 */
public class DiscountFactory {

	public static Discount createDiscount(Bill bill) {

		User user = bill.getUser();

		// create discount type object on the basis of user type.
		if (user.getUserType().equals(Constants.USER_TYPE_EMPLOYEE)) {
			return new EmployeeDiscount();
		} else if (user.getUserType().equals(Constants.USER_TYPE_CUSTOMER)
				&& DateCompare.getDiffYears(user.getRegistrationDate(), "20240923") <= 2) {
			user.setUserType(Constants.USER_TYPE_NEW_CUSTOMER);
			return new NoDiscount();
		} else if (user.getUserType().equals(Constants.USER_TYPE_AFFILIATE)) {
			return new AffiliateDiscount();
		} else if (user.getUserType().equals(Constants.USER_TYPE_CUSTOMER)) {
			return new CustomerDiscount();
		} else {

			return new NoDiscount();
		}
	}
}
