package com.bridgelabz.addressbook.dto;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import lombok.ToString;

public @ToString class AddressBookDTO {

	@Pattern(regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$", message="Contact first name invalid")
	public String fname;
	
	@Pattern(regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$", message="Contact last name invalid")
	public String lname;
	
	@Pattern(regexp="(0/91)?[7-9][0-9]{9}",message="Phone No Invalid")
	@Min(10)
	public String phoneNum;
	
	public List<String> addressbook_type;
		
}
