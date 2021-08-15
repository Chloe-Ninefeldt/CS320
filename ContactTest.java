/*
 * Chloe Ninefeldt
 * CS 320 
 * Project One
 * 08/04/2021
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest {
	protected String contactId, firstNameTest, lastNameTest, phoneNumberTest,
    addressTest;
protected String tooLongContactId, tooLongFirstName, tooLongLastName,
    tooLongPhoneNumber, tooShortPhoneNumber, tooLongAddress;

@BeforeEach
void setUp() {
  contactId = "000000001";
  firstNameTest = "Chloe";
  lastNameTest = "Ninefeldt";
  phoneNumberTest = "5553331234";
  addressTest = "208 Armadillo Ln, Bastrop TX";
  tooLongContactId = "112233445566778899";
  tooLongFirstName = "Chloe Ninefeldt";
  tooLongLastName = "Chloe Ninefeldt";
  tooLongPhoneNumber = "55512341234";
  tooShortPhoneNumber = "1234567";
  tooLongAddress = "208 Armadillo Ln, Bastrop TX, 208 Armadillo Ln, Bastrop TX";
}
//test adding new contact
@Test
void contactTest() {
  Contact contact = new Contact();
  assertAll("Main Constructor",
            ()
                -> assertNotNull(contact.getContactId()),
            ()
                -> assertNotNull(contact.getFirstName()),
            ()
                -> assertNotNull(contact.getLastName()),
            ()
                -> assertNotNull(contact.getPhoneNumber()),
            () -> assertNotNull(contact.getAddress()));
}


//test contact ID
@Test
void contactIdConstructorTest() {
  Contact contact = new Contact(contactId);
  assertAll("Constructor ID",
            ()
                -> assertEquals(contactId, contact.getContactId()),
            ()
                -> assertNotNull(contact.getFirstName()),
            ()
                -> assertNotNull(contact.getLastName()),
            ()
                -> assertNotNull(contact.getPhoneNumber()),
            () -> assertNotNull(contact.getAddress()));
}


//test first name and ID
@Test
void contactIdAndFirstNameConstructorTest() {
  Contact contact = new Contact(contactId, firstNameTest);
  assertAll("Constructor First Name",
            ()
                -> assertEquals(contactId, contact.getContactId()),
            ()
                -> assertEquals(firstNameTest, contact.getFirstName()),
            ()
                -> assertNotNull(contact.getLastName()),
            ()
                -> assertNotNull(contact.getPhoneNumber()),
            () -> assertNotNull(contact.getAddress()));
}

//test Id, first name, and last name
@Test
void contactIdAndFullNameConstructorTest() {
  Contact contact = new Contact(contactId, firstNameTest, lastNameTest);
  assertAll("Constructor Last Name",
            ()
                -> assertEquals(contactId, contact.getContactId()),
            ()
                -> assertEquals(firstNameTest, contact.getFirstName()),
            ()
                -> assertEquals(lastNameTest, contact.getLastName()),
            ()
                -> assertNotNull(contact.getPhoneNumber()),
            () 
            	-> assertNotNull(contact.getAddress()));
}

//test contact ID, first name, last name, phone number 
@Test
void contactIdFullNamePhoneNumberConstructorTest() {
  Contact contact =
      new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest);
  assertAll("Constructor Phone Number",
            ()
                -> assertEquals(contactId, contact.getContactId()),
            ()
                -> assertEquals(firstNameTest, contact.getFirstName()),
            ()
                -> assertEquals(lastNameTest, contact.getLastName()),
            ()
                -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
            () -> assertNotNull(contact.getAddress()));
}

//test everything together
@Test
void allTheProperThingsConstructorTest() {
  Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
  assertAll("Constructor All",
            ()
                -> assertEquals(contactId, contact.getContactId()),
            ()
                -> assertEquals(firstNameTest, contact.getFirstName()),
            ()
                -> assertEquals(lastNameTest, contact.getLastName()),
            ()
                -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
            () -> assertEquals(addressTest, contact.getAddress()));
}

//test update first name
@Test
void updateFirstNameTest() {
  Contact contact = new Contact();
  contact.updateFirstName(firstNameTest);
  assertAll("First Name",
      ()
          -> assertEquals(firstNameTest, contact.getFirstName()),
      ()
          -> assertThrows(IllegalArgumentException.class,
                          () -> contact.updateFirstName(null)),
      ()
          -> assertThrows(IllegalArgumentException.class,
                          () -> contact.updateFirstName(tooLongFirstName)));
}

//test update last name
@Test
void updateLastNameTest() {
  Contact contact = new Contact();
  contact.updateLastName(lastNameTest);
  assertAll("Last Name",
      ()
          -> assertEquals(lastNameTest, contact.getLastName()),
      ()
          -> assertThrows(IllegalArgumentException.class,
                          () -> contact.updateLastName(null)),
      ()
          -> assertThrows(IllegalArgumentException.class,
                          () -> contact.updateLastName(tooLongFirstName)));
}

//test updating phone number
@Test
void updatePhoneNumberTest() {
  Contact contact = new Contact();
  contact.updatePhoneNumber(phoneNumberTest);
  assertAll("Phone Number",
            ()
                -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
            ()
                -> assertThrows(IllegalArgumentException.class,
                                () -> contact.updatePhoneNumber(null)),
            ()
                -> assertThrows(
                    IllegalArgumentException.class,
                    () -> contact.updatePhoneNumber(tooLongPhoneNumber)),
            ()
                -> assertThrows(
                    IllegalArgumentException.class,
                    () -> contact.updatePhoneNumber(tooShortPhoneNumber)),
            ()
                -> assertThrows(IllegalArgumentException.class,
                                () -> contact.updatePhoneNumber(contactId)));
}

//test updating address
@Test
void updateAddressTest() {
  Contact contact = new Contact();
  contact.updateAddress(addressTest);
  assertAll("Address",
            ()
                -> assertEquals(addressTest, contact.getAddress()),
            ()
                -> assertThrows(IllegalArgumentException.class,
                                () -> contact.updateAddress(null)),
            ()
                -> assertThrows(IllegalArgumentException.class,
                                () -> contact.updateAddress(tooLongAddress)));
}

//test updating contact ID
@Test
void updateContactIdTest() {
  Contact contact = new Contact();
  contact.updateContactId(contactId);
  assertAll("Contact ID",
      ()
          -> assertEquals(contactId, contact.getContactId()),
      ()
          -> assertThrows(IllegalArgumentException.class,
                          () -> contact.updateContactId(null)),
      ()
          -> assertThrows(IllegalArgumentException.class,
                          () -> contact.updateContactId(tooLongContactId)));
}
}
