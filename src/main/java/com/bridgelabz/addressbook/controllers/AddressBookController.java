package com.bridgelabz.addressbook.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.addressbook.dto.ResponseDTO;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

	@RequestMapping({"","/","/get"})
	public ResponseEntity<ResponseDTO> getAddrBookdata(){
		
	}
}
