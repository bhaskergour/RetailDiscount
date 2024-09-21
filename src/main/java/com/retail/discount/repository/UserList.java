package com.retail.discount.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.retail.discount.model.User;

@Component
public class UserList {
	static Map<Integer, User> mUser = new HashMap<Integer, User>();

	public static Map<Integer, User> addUser() {

		mUser.put(100, new User(100, "Amit", "employee", "20201212"));
		mUser.put(101, new User(101, "Rohan", "employee", "20201212"));
		mUser.put(102, new User(102, "sohan", "customer", "20201212"));
		mUser.put(103, new User(103, "Ram", "affiliate", "20201212"));
		mUser.put(104, new User(104, "shayam", "customer", "20241212"));
		return mUser;

	}

	public User findUserByID(Integer id) {

		return mUser.get(id);
	}
}
