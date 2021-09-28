package com.bridgelabz.addressbook.model;

import com.bridgelabz.addressbook.dto.AddressBookDTO;

public class AddressBookData {

	private int contactId;
	public String fname;
	public String lname;
	public String phoneNum;
	
	public AddressBookData(int contactId, AddressBookDTO addressBookDTO) {
		super();
		this.contactId = contactId;
		this.fname = addressBookDTO.fname;
		this.lname = addressBookDTO.lname;
		this.phoneNum = addressBookDTO.phoneNum;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	
}
