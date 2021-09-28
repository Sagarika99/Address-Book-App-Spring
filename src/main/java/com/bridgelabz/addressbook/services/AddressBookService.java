package com.bridgelabz.addressbook.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.exceptions.AddressBookException;
import com.bridgelabz.addressbook.model.AddressBookData;

@Service
public class AddressBookService implements IAddressBookService{

	private List<AddressBookData> addrBookList = new ArrayList<>();
	
	@Override
	public List<AddressBookData> getAddrBookdata() {		
		return addrBookList;
	}

	@Override
	public AddressBookData getAddrBookdata(int contactId) {
		return addrBookList.stream().filter(contactData->contactData.getContactId()==contactId)
				.findFirst()
				.orElseThrow(()->new AddressBookException("contact not found"));
	}

	@Override
	public AddressBookData addAddrBookdata(AddressBookDTO addressbookDTO) {
		AddressBookData addrBookData=null;
		addrBookData=new AddressBookData(1,addressbookDTO);
		addrBookList.add(addrBookData);
		return addrBookData;
	}

	@Override
	public AddressBookData updateAddrBookdata(int contactId, AddressBookDTO addressbookDTO) {
		AddressBookData addrBookData=null;
		addrBookData=new AddressBookData(contactId,addressbookDTO);
		addrBookData.setFname(addressbookDTO.fname);
		addrBookData.setLname(addressbookDTO.lname);
		addrBookData.setPhoneNum(addressbookDTO.phoneNum);
		addrBookList.set(contactId-1, addrBookData);
		return addrBookData;
	}

	@Override
	public void deleteAddrBookdata(int contactId) {
		addrBookList.remove(contactId-1);
		
	}

}
