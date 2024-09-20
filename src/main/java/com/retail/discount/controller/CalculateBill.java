package com.retail.discount.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retail.discount.entity.BillGeneration;
import com.retail.discount.entity.BillItem;
import com.retail.discount.model.User;
import com.retail.discount.repository.ItemList;
import com.retail.discount.repository.UserList;
import com.retail.discount.service.Bill;
import com.retail.discount.service.CalculateDiscount;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CalculateBill {

	@Autowired
	ItemList itemlist;
	@Autowired
	UserList userlist;
	@Autowired
	CalculateDiscount cd;
	@Autowired
	Bill bill;

	@GetMapping("/generatebill")	
	public Bill getBill(@RequestBody BillGeneration bg) throws  IOException {

		UserList.addUser();
		ItemList.addItem();
		User userData = userlist.findUserByID(bg.getUserID());
		bill.setBillNumber(bg.getBillNumber());
		bill.setUser(userData);
		bill.setItems(bg.getItems());

		for (BillItem item : bill.getItems()) {

			item.setItemType(ItemList.findItemTypeByName(item.getItemName()));
		}
		cd.discountCalculation(bill);

		return bill;
	}
}
