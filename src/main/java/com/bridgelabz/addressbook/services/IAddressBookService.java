package com.bridgelabz.addressbook.services;

import java.util.List;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBookData;

public interface IAddressBookService {

	List<AddressBookData> getAddrBookdata();
	
	AddressBookData getAddrBookdata(int contactId);
	
	AddressBookData addAddrBookdata(AddressBookDTO addressbookDTO);
	
	AddressBookData updateAddrBookdata(int empId, AddressBookDTO addressbookDTO);
	
	void deleteAddrBookdata(int contactId);
}
