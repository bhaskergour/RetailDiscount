package com.retail.discount.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class ItemList {
	static Map<String, String> mItem = new HashMap<String, String>();

	public static Map<String, String> addItem() {

		mItem.put("Mobile", "electronics");
		mItem.put("Charger", "electronics");
		mItem.put("Soap", "grocery");
		mItem.put("Oil", "grocery");

		return mItem;

	}

	public static String findItemTypeByName(String name) {

		return mItem.get(name);
	}
}
