package com.retail.discount.entity;

import java.util.List;

public class BillGeneration {
	int userID;
	List<BillItem> items;
	int billNumber;

	public int getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(int billNumber) {
		this.billNumber = billNumber;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public List<BillItem> getItems() {
		return items;
	}

	public void setItems(List<BillItem> items) {
		this.items = items;
	}

}
