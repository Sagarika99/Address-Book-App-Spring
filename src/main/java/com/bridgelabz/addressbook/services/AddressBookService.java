package com.bridgelabz.addressbook.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.exceptions.AddressBookException;
import com.bridgelabz.addressbook.model.AddressBookData;
import com.bridgelabz.addressbook.repository.AddressBookRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService{
	
	@Autowired
	private AddressBookRepository addrBookRepository;

	private List<AddressBookData> addrBookList = new ArrayList<>();
	
	@Override
	public List<AddressBookData> getAddrBookdata() {		
		return addrBookList;
	}

	@Override
	public AddressBookData getAddrBookdata(int contactId) {
		return addrBookList.stream().filter(contactData->contactData.getContactId()==contactId)
				.findFirst()
				.orElseThrow(()->new AddressBookException("Contact not found"));
	}

	@Override
	public AddressBookData addAddrBookdata(AddressBookDTO addressbookDTO) {
		AddressBookData addrBookData=null;
		addrBookData=new AddressBookData(addressbookDTO);
		addrBookList.add(addrBookData);
		log.debug("Contact data: "+addrBookData.toString());
		return addrBookRepository.save(addrBookData);
	}

	@Override
	public AddressBookData updateAddrBookdata(int contactId, AddressBookDTO addressbookDTO) {
		AddressBookData addrBookData=null;
		addrBookData=new AddressBookData(addressbookDTO);
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
