package com.edubridge.contactapp;

import java.util.List;
import java.util.Scanner;

import com.edubridge.contactapp.dao.ContactDao;
import com.edubridge.contactapp.dao.ContactDaoImpl;
import com.edubridge.contactapp.model.contact;

public class App 
{
    public static void main( String[] args ) {
    	ContactDao dao= new ContactDaoImpl();
    	
    	Scanner in=new Scanner(System.in);
    	while(true) {
    		System.out.println("MT CONTACT APP");
    		System.out.println("---------------");
    		System.out.println("1.ADD CONTACT");
    		System.out.println("2.VIEW CONTACT");
    		System.out.println("3.SEARCH CONTACT");
    		System.out.println("4.UPDATE CONTACT");
    		System.out.println("5.DELETE CONTACT");
    		System.out.println("6.DELETE ALL CONTACT");
    		System.out.println("PLEASE CHOOSE OPTION:");
    		int option=in.nextInt();
    		
    		switch (option) {
    		case 1:
    			System.out.println("please enter contact name:");
    			String name1=in.next();
    			
    			System.out.println("please enter contact email:");
    			String email=in.next();
    			
    			System.out.println("please enter contact mobile:");
    			long mobile=in.nextLong();
    			
    			contact newcontact=new contact();
    			newcontact.setName(name1);
    			newcontact.setEmail(email);
    			newcontact.setMobile(mobile);
    			
    			int status=dao.addContact(newcontact);
    			if(status>=1) {
    				System.out.println("New Contact Saved!!!");
    			}else {
    				System.out.println("Something is Wrong!!!");
    			}
    			
    		    break;
    		case 2:
    			System.out.println("contact List");
    			System.out.println("---------------------");
    			List<contact> contacts=dao.getAllcontacts();
    			if(contacts.size()!=0) {
    				for(contact c: contacts) {
    					System.out.println(c.getId()+"\t"+c.getName()+"\t"+c.getEmail()+"\t"+c.getMobile());
 
    				}
    			}else {
    				System.out.println("no contacts found");
    			}
    			break;
    			
    		case 3:
                System.out.println("Please enter name to search:");
                String name = in.next();
                contact contact=dao.searchContacts(name);
                if (contact != null) {
                     {
                        System.out.println(contact.getId() + "\t" + contact.getName() + "\t" + contact.getEmail() + "\t" + contact.getMobile());
                    }
                } else {
                    System.out.println("No contacts found");
                }
                break;
                
    		case 0:
    			System.out.println("Bye!!");
    			System.exit(0);
    			
    		default:
    			System.out.println("Invalid Option!!!");
    			break;
    			
    		case 4:
    			
    			System.out.println("Please enter the name of the contact to update:");
                String updateName = in.next();
                contact existingContact = dao.searchContacts(updateName);
                if(existingContact != null) {
                    System.out.println("Enter new email:");
                    String newEmail = in.next();
                    System.out.println("Enter new mobile:");
                    Long newMobile = in.nextLong();
                    
                    existingContact.setEmail(newEmail);
                    existingContact.setMobile(newMobile);
                    
                    int updateStatus = dao.updateContact(existingContact);
                    if(updateStatus >= 1) {
                        System.out.println("Contact updated successfully!");
                    } else {
                        System.out.println("Update failed.");
                    }
                } else {
                    System.out.println("Contact not found.");
                }
                break;
    			
    			
    		}
    		
    		
    		}
    
        
    }
}
