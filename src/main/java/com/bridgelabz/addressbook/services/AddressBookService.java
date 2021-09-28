package com.bridgelabz.addressbook.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBookData;

@Service
public class AddressBookService implements IAddressBookService{

	@Override
	public List<AddressBookData> getAddrBookdata() {
		List<AddressBookData> addrBookList=new ArrayList<>();
		addrBookList.add(new AddressBookData(1,new AddressBookDTO("Pankaj","Shah","9887786789")));		
		return addrBookList;
	}

	@Override
	public AddressBookData getAddrBookdata(int contactId) {
		AddressBookData addrBookData=null;
		addrBookData=new AddressBookData(contactId,new AddressBookDTO("Pankaj","Shah","9887786789"));
		return addrBookData;
	}

	@Override
	public AddressBookData addAddrBookdata(AddressBookDTO addressbookDTO) {
		AddressBookData addrBookData=null;
		addrBookData=new AddressBookData(3,addressbookDTO);
		return addrBookData;
	}

	@Override
	public AddressBookData updateAddrBookdata(int empId, AddressBookDTO addressbookDTO) {
		AddressBookData addrBookData=null;
		addrBookData=new AddressBookData(empId,addressbookDTO);
		return addrBookData;
	}

	@Override
	public void deleteAddrBookdata(int contactId) {
		// TODO Auto-generated method stub
		
	}

}
