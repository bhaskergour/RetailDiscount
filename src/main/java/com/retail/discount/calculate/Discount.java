package com.retail.discount.calculate;

import com.retail.discount.service.Bill;

/**
 * Common interface to be implemented by all the type of discounts
 */
public interface Discount {

	Bill applyDiscount(Bill bill);
}
