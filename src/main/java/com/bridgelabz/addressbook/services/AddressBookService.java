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

	
	@Override
	public List<AddressBookData> getAddrBookdata() {		
		return addrBookRepository.findAll();
	}
	

	@Override
	public List<AddressBookData> findContactByAddressBookType(String bookType) {
		return addrBookRepository.findContactByAddressBookType(bookType);
	}

	@Override
	public AddressBookData getAddrBookdata(int contactId) {
		return addrBookRepository.findById(contactId)
				.orElseThrow(()->new AddressBookException("Contact not found"));
	}

	@Override
	public AddressBookData addAddrBookdata(AddressBookDTO addressbookDTO) {
		AddressBookData addrBookData=null;
		addrBookData=new AddressBookData(addressbookDTO);
		log.debug("Contact data: "+addrBookData.toString());
		return addrBookRepository.save(addrBookData);
	}

	@Override
	public AddressBookData updateAddrBookdata(int contactId, AddressBookDTO addressbookDTO) {
		AddressBookData addrBookData=this.getAddrBookdata(contactId);
		addrBookData.updateAddressBookData(addressbookDTO);
		return addrBookRepository.save(addrBookData);
	}

	@Override
	public void deleteAddrBookdata(int contactId) {
		AddressBookData addrBookData=this.getAddrBookdata(contactId);
		addrBookRepository.delete(addrBookData);
		
	}


}
