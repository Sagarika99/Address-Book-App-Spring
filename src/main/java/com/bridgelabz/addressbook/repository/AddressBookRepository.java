package com.bridgelabz.addressbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bridgelabz.addressbook.model.AddressBookData;

public interface AddressBookRepository extends JpaRepository<AddressBookData, Integer>{

	@Query(value="select * from address_book, addressbook_type where contact_id = id and book_type = :bookType ", nativeQuery = true)
	List<AddressBookData> findContactByAddressBookType(String bookType);
}
