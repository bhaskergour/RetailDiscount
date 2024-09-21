package com.retail.discount.model;

public class User {

	private long id;

	private String userName;

	private String userType;

	private String registrationDate;

	public User(int id, String userName, String userType, String registrationDate) {
		super();
		this.id = id;
		this.userName = userName;
		this.userType = userType;
		this.registrationDate = registrationDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userType=" + userType + ", registrationDate="
				+ registrationDate + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}
}
