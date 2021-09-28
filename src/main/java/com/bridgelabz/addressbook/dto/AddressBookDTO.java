package com.bridgelabz.addressbook.dto;

public class AddressBookDTO {

	public String fname;
	public String lname;
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
