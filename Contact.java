/*
 * Chloe Ninefeldt
 * CS 320 
 * Project One
 * 08/04/2021
 */

public class Contact {

	  private static final int Phone_Num_Length = 10;
	  private static final byte ID_Length = 10;
	  private static final byte first_name_length = 10;
	  private static final byte last_name_length = 10;
	  private static final byte address_length = 30;
	  private static final String INITIALIZER = "INITIAL";
	  private static final String INITIALIZER_NUM = "1235559999";
	  private String contactId;
	  private String firstName;
	  private String lastName;
	  private String phoneNumber;
	  private String address;

	  
//initialize contact	  
	  Contact() {
	    this.contactId = INITIALIZER;
	    this.firstName = INITIALIZER;
	    this.lastName = INITIALIZER;
	    this.phoneNumber = INITIALIZER_NUM;
	    this.address = INITIALIZER;
	  }
//update contact ID
	  Contact(String contactId) {
	    updateContactId(contactId);
	    this.firstName = INITIALIZER;
	    this.lastName = INITIALIZER;
	    this.phoneNumber = INITIALIZER_NUM;
	    this.address = INITIALIZER;
	  }
//update contact ID and first name
	  Contact(String contactId, String firstName) {
	    updateContactId(contactId);
	    updateFirstName(firstName);
	    this.lastName = INITIALIZER;
	    this.phoneNumber = INITIALIZER_NUM;
	    this.address = INITIALIZER;
	  }
//update contact ID, first name, and last name
	  Contact(String contactId, String firstName, String lastName) {
	    updateContactId(contactId);
	    updateFirstName(firstName);
	    updateLastName(lastName);
	    this.phoneNumber = INITIALIZER_NUM;
	    this.address = INITIALIZER;
	  }
//update contact ID, first name, last name, and phone number
	  Contact(String contactId, String firstName, String lastName, String phoneNumber) {
	    updateContactId(contactId);
	    updateFirstName(firstName);
	    updateLastName(lastName);
	    updatePhoneNumber(phoneNumber);
	    this.address = INITIALIZER;
	  }
//update contact ID, first name, last name, phone number, and address
	  Contact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
	    updateContactId(contactId);
	    updateFirstName(firstName);
	    updateLastName(lastName);
	    updatePhoneNumber(phoneNumber);
	    updateAddress(address);
	  }
	  
// get contact information and returning the right information
	  protected final String getContactId() { return contactId; }

	  protected final String getFirstName() { return firstName; }

	  protected final String getLastName() { return lastName; }

	  protected final String getPhoneNumber() { return phoneNumber; }

	  protected final String getAddress() { return address; }
  
//updating first name only with not being more than 10 characters and not null
	  protected void updateFirstName(String firstName) {
	    if (firstName == null) {
	      throw new IllegalArgumentException("First name cannot be blank");
	    } else if (firstName.length() > first_name_length) {
	      throw new IllegalArgumentException("First name cannot exceed " + first_name_length + " characters");
	    } else {
	      this.firstName = firstName;
	    }
	  }

//updating last name only with not being more than 10 characters and not null	  
	  protected void updateLastName(String lastName) {
	    if (lastName == null) {
	      throw new IllegalArgumentException("Last name cannot be blank");
	    } else if (lastName.length() > last_name_length) {
	      throw new IllegalArgumentException("Last name cannot exceed " + last_name_length + " characters");
	    } else {
	      this.lastName = lastName;
	    }
	  }

//update phone number, making sure it's only 10 digits, not null, and only be numbers
	  protected void updatePhoneNumber(String phoneNumber) {
	    String regex = "[0-9]+";
	    if (phoneNumber == null) {
	      throw new IllegalArgumentException("Phone number cannot be blank.");
	    } else if (phoneNumber.length() != Phone_Num_Length) {
	      throw new IllegalArgumentException("Phone number length invalid. Please make sure it is" + Phone_Num_Length + " digits.");
	    } else if (!phoneNumber.matches(regex)) {
	      throw new IllegalArgumentException("Phone number must only contain numbers.");
	    } else {
	      this.phoneNumber = phoneNumber;
	    }
	  }

//updating address, making sure it's under 30 characters and not null	  
	  protected void updateAddress(String address) {
	    if (address == null) {
	      throw new IllegalArgumentException("Address cannot be blank");
	    } else if (address.length() > address_length) {
	      throw new IllegalArgumentException("Address cannot exceed " + address_length + " characters");
	    } else {
	      this.address = address;
	    }
	  }

	  
//updating contact ID, making sure it is 10 digits and not null	  
	  protected void updateContactId(String contactId) {
	    if (contactId == null) {
	      throw new IllegalArgumentException("Contact ID cannot be blank");
	    } else if (contactId.length() > ID_Length) {
	      throw new IllegalArgumentException("Contact ID cannot exceed" + ID_Length + " characters");
	    } else {
	      this.contactId = contactId;
	    }
	  }
}
