package com.retail.discount.utility;

public class DateCompare {

	public static int getDiffYears(String first, String last) {

		return Integer.parseInt(last.substring(0, Math.min(last.length(), 4)))
				- Integer.parseInt(first.substring(0, Math.min(first.length(), 4)));
	}

}
