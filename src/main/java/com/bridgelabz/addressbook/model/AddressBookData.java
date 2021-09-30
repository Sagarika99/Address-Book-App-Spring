package com.bridgelabz.addressbook.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.bridgelabz.addressbook.dto.AddressBookDTO;

import lombok.Data;

@Entity
@Table(name="address_book")
public @Data class AddressBookData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="contact_Id")
	private int contactId;
	@Column(name="first_name")
	private String fname;
	@Column(name="last_name")
	private String lname;
	@Column(name="phone_Num")
	private String phoneNum;
	
	@ElementCollection
	@CollectionTable(name="addressbook_type", joinColumns = @JoinColumn(name="id"))
	@Column(name="book_type")
	public List<String> addressbook_type;
	
	public AddressBookData() {}
	
	public AddressBookData(AddressBookDTO addressBookDTO) {
		this.updateAddressBookData(addressBookDTO);
	}
	
	public void updateAddressBookData(AddressBookDTO addressBookDTO) {
		//this.contactId = contactId;
		this.fname = addressBookDTO.fname;
		this.lname = addressBookDTO.lname;
		this.phoneNum = addressBookDTO.phoneNum;
		this.addressbook_type = addressBookDTO.addressbook_type;
	}
	
}
