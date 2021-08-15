/*
 * Chloe Ninefeldt
 * CS 320 
 * Project One
 * 08/04/2021
 */


import java.util.UUID;
import java.util.ArrayList;
import java.util.List;


public class ContactService {
	
	//create uniqueID with list
	private String uniqueId;
	  private List<Contact> contactList = new ArrayList<>();

	  {
	    setUniqueId(UUID.randomUUID().toString().substring(
	        0, Math.min(toString().length(), 10)));
	  }
//new contact gets new unique ID
	  public void newContact() {
	    Contact contact = new Contact(newUniqueId());
	    contactList.add(contact);
	  }
//new contact needs ID and first name
	  public void newContact(String firstname) {
	    Contact contact = new Contact(newUniqueId(), firstname);
	    contactList.add(contact);
	  }
// new contact needs ID, first and last name
	  public void newContact(String firstname, String lastname) {
	    Contact contact = new Contact(newUniqueId(), firstname, lastname);
	    contactList.add(contact);
	  }
//new contact needs ID, first name, last name, and phone number
	  public void newContact(String firstname, String lastname,
	                         String phonenumber) {
	    Contact contact =
	        new Contact(newUniqueId(), firstname, lastname, phonenumber);
	    contactList.add(contact);
	  }
//new contact needs ID, first name, last name, phone number and address
	  public void newContact(String firstname, String lastname, String phonenumber,
	                         String address) {
//add new contact
		  Contact contact =
	        new Contact(newUniqueId(), firstname, lastname, phonenumber, address);
	    contactList.add(contact);
	  }

//delete contact - delete contact ID
	  public void deleteContact(String id) throws Exception {
	    contactList.remove(searchForContact(id));
	  }
//update first name
	  public void updateFirstName(String id, String firstName) throws Exception {
	    searchForContact(id).updateFirstName(firstName);
	  }
//update last name
	  public void updateLastName(String id, String lastName) throws Exception {
	    searchForContact(id).updateLastName(lastName);
	  }
//update phone number
	  public void updatePhoneNumber(String id, String phoneNumber)
	      throws Exception {
	    searchForContact(id).updatePhoneNumber(phoneNumber);
	  }
//update address
	  public void updateAddress(String id, String address) throws Exception {
	    searchForContact(id).updateAddress(address);
	  }

	  protected List<Contact> getContactList() { return contactList; }

	  private String newUniqueId() {
	    return setUniqueId(UUID.randomUUID().toString().substring(
	               0, Math.min(toString().length(), 10)));
	  }

	  private Contact searchForContact(String id) throws Exception {
	    int index = 0;
	    while (index < contactList.size()) {
	      if (id.equals(contactList.get(index).getContactId())) {
	        return contactList.get(index);
	      }
	      index++;
	    }
	    throw new Exception("Please try again.");
	  }
	public String getUniqueId() {
		return uniqueId;
	}
	public String setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
		return uniqueId;
	}
}
