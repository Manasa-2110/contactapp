package com.edubridge.contactapp.dao;//data access object

import java.util.List;

import com.edubridge.contactapp.model.contact;

public interface ContactDao {
	int addContact(contact c);
	List<contact>getAllcontacts();
	contact getContact(String name);
	int updateContact(contact c);
	void deleteAllContacts();
	//
	
	contact searchContacts(String name);
	
}
