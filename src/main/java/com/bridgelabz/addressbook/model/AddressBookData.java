package com.bridgelabz.addressbook.model;

import java.util.List;

import com.bridgelabz.addressbook.dto.AddressBookDTO;

import lombok.Data;

public @Data class AddressBookData {

	private int contactId;
	private String fname;
	private String lname;
	private String phoneNum;
	
	public List<String> addressbook_type;
	
	public AddressBookData() {}
	
	public AddressBookData(int contactId, AddressBookDTO addressBookDTO) {
		super();
		this.contactId = contactId;
		this.fname = addressBookDTO.fname;
		this.lname = addressBookDTO.lname;
		this.phoneNum = addressBookDTO.phoneNum;
		this.addressbook_type = addressBookDTO.addressbook_type;
	}
	
}
