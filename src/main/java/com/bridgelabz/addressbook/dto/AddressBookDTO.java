package com.bridgelabz.addressbook.dto;

import javax.validation.constraints.Pattern;

public class AddressBookDTO {

	@Pattern(regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$", message="Contact first name invalid")
	public String fname;
	@Pattern(regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$", message="Contact last name invalid")
	public String lname;
	@Pattern(regexp="(0/91)?[7-9][0-9]{9}",message="Phone No Invalid")
	public String phoneNum;
		
	public AddressBookDTO() {
	}
	public AddressBookDTO(String fname, String lname, String phoneNum) {
		this.fname = fname;
		this.lname = lname;
		this.phoneNum = phoneNum;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	@Override
	public String toString() {
		return "addressbookDTO [fname=" + fname + ", lname=" + lname + ", phoneNum=" + phoneNum + "]";
	}
}
