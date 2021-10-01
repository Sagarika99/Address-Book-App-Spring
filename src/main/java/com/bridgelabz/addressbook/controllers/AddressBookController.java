package com.bridgelabz.addressbook.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.model.AddressBookData;
import com.bridgelabz.addressbook.services.IAddressBookService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/addressbook")
@Slf4j
public class AddressBookController {

	@Autowired
	private IAddressBookService addrBookService;
	
	@RequestMapping({"","/","/get"})
	public ResponseEntity<ResponseDTO> getAddrBookdata(){
		List<AddressBookData> addrBookData = null;
		addrBookData = addrBookService.getAddrBookdata();
		ResponseDTO respDTO=new ResponseDTO("Get call Success",addrBookData);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
	
	@GetMapping("/get/{contactId}")
	public ResponseEntity<ResponseDTO> getAddrBookdata(@PathVariable("contactId") int contactId){
		AddressBookData addrBookData = null;
		addrBookData = addrBookService.getAddrBookdata(contactId);
		ResponseDTO respDTO=new ResponseDTO("Get call for ID Success",addrBookData);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
	
	@GetMapping("/get/booktype")
	public ResponseEntity<ResponseDTO> getAddrBookdata(@RequestParam String booktype){
		List<AddressBookData> addrBookData = null;
		addrBookData = addrBookService.findContactByAddressBookType(booktype);
		ResponseDTO respDTO=new ResponseDTO("Get call for ID Success",addrBookData);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addAddrBookdata(@Valid @RequestBody AddressBookDTO addressbookDTO){
		log.debug("Address Book DTO: "+addressbookDTO.toString());
		AddressBookData addrBookData = null;
		addrBookData = addrBookService.addAddrBookdata(addressbookDTO);
		ResponseDTO respDTO=new ResponseDTO("Added Employee Payroll Data Sucessfully",addrBookData);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{contactId}")
	public ResponseEntity<ResponseDTO> updateAddrBookdata(@Valid @PathVariable("contactId") int contactId,@RequestBody AddressBookDTO addressbookDTO){
		AddressBookData addrBookData = null;
		addrBookData = addrBookService.updateAddrBookdata(contactId, addressbookDTO);
		ResponseDTO respDTO=new ResponseDTO("Updated Employee Payroll Data Sucessfully",addrBookData);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{contactId}")
	public ResponseEntity<ResponseDTO> deleteAddrBookdata(@PathVariable("contactId") int contactId){
		addrBookService.deleteAddrBookdata(contactId);
		ResponseDTO respDTO=new ResponseDTO("Deleted Sucessfully","Deleted Id: "+contactId);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
}
