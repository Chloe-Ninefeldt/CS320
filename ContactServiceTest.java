/*
 * Chloe Ninefeldt
 * CS 320 
 * Project One
 * 08/04/2021
 */


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
	protected String contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest;
protected String tooLongContactId, tooLongFirstName, tooLongLastName, tooLongPhoneNumber, tooShortPhoneNumber, tooLongAddress;



//set test strings to make sure everything works properly
@BeforeEach
void setUp() {
  contactId = "000000001";
  firstNameTest = "Chloe";
  lastNameTest = "Ninefeldt";
  phoneNumberTest = "1112223456";
  addressTest = "208 Armadillo Ln Bastrop TX";
  tooLongContactId = "00000000011";
  tooLongFirstName = "Chloe Ninefeldt";
  tooLongLastName = "Chloe Ninefeldt";
  tooLongPhoneNumber = "55512341234";
  tooShortPhoneNumber = "1234567";
  tooLongAddress = "208 Armadillo Ln Bastrop TX, 208 Armadillo Ln Bastrop TX";
}

//test adding a new contact
@Test
void newContactTest() {
  ContactService service = new ContactService();
  service.newContact();
  assertAll("service",
      ()
          -> assertNotNull(service.getContactList().get(0).getContactId()),
      ()
          -> assertEquals("INITIAL", service.getContactList().get(0).getFirstName()),
      ()
          -> assertEquals("INITIAL", service.getContactList().get(0).getLastName()),
      ()
          -> assertEquals("1235559999", service.getContactList().get(0).getPhoneNumber()),
      ()
          -> assertEquals("INITIAL", service.getContactList().get(0).getAddress()));
  
  //test adding new contact testing the first name
  service.newContact(firstNameTest);
  assertAll("service",
      ()
          -> assertNotNull(service.getContactList().get(1).getContactId()),
      ()
          -> assertEquals(firstNameTest, service.getContactList().get(1).getFirstName()),
      ()
          -> assertEquals("INITIAL", service.getContactList().get(1).getLastName()),
      ()
          -> assertEquals("1235559999", service.getContactList().get(1).getPhoneNumber()),
      ()
          -> assertEquals("INITIAL", service.getContactList().get(1).getAddress()));
  
  //test adding new contact testing first and last name
  service.newContact(firstNameTest, lastNameTest);
  assertAll("service",
      ()
          -> assertNotNull(service.getContactList().get(2).getContactId()),
      ()
          -> assertEquals(firstNameTest, service.getContactList().get(2).getFirstName()),
      ()
          -> assertEquals(lastNameTest, service.getContactList().get(2).getLastName()),
      ()
          -> assertEquals("1235559999", service.getContactList().get(2).getPhoneNumber()),
      ()
          -> assertEquals("INITIAL", service.getContactList().get(2).getAddress()));
  
  //test adding new contact testing first name, last name, and phone number
  service.newContact(firstNameTest, lastNameTest, phoneNumberTest);
  assertAll("service",
      ()
          -> assertNotNull(service.getContactList().get(3).getContactId()),
      ()
          -> assertEquals(firstNameTest, service.getContactList().get(3).getFirstName()),
      ()
          -> assertEquals(lastNameTest, service.getContactList().get(3).getLastName()),
      ()
          -> assertEquals(phoneNumberTest, service.getContactList().get(3).getPhoneNumber()),
      ()
          -> assertEquals("INITIAL", service.getContactList().get(3).getAddress()));
  
  //test adding new contact testing first name, last name, phone number, and address
  service.newContact(firstNameTest, lastNameTest, phoneNumberTest,addressTest);
  assertAll("service",
      ()
          -> assertNotNull(service.getContactList().get(4).getContactId()),
      ()
          -> assertEquals(firstNameTest, service.getContactList().get(4).getFirstName()),
      ()
          -> assertEquals(lastNameTest, service.getContactList().get(4).getLastName()),
      ()
          -> assertEquals(phoneNumberTest, service.getContactList().get(4).getPhoneNumber()),
      ()
          -> assertEquals(addressTest, service.getContactList().get(4).getAddress()));
}


//test deleting a contact
@Test
void deleteContactTest() {
  ContactService service = new ContactService();
  service.newContact();
  assertThrows(Exception.class, () -> service.deleteContact(contactId));
  assertAll(()
                -> service.deleteContact(service.getContactList().get(0).getContactId()));
}


//test updating the first name
@Test
void updateFirstNameTest() throws Exception {
  ContactService service = new ContactService();
  service.newContact();
  service.updateFirstName(service.getContactList().get(0).getContactId(), firstNameTest);
  assertEquals(firstNameTest, service.getContactList().get(0).getFirstName());
  //error if first name is too long
  assertThrows(IllegalArgumentException.class,
               ()
                   -> service.updateFirstName(service.getContactList().get(0).getContactId(), tooLongFirstName));
  //error if first name is null
  assertThrows(IllegalArgumentException.class,
               ()
                   -> service.updateFirstName(service.getContactList().get(0).getContactId(), null));
  assertThrows(Exception.class,
               () -> service.updateFirstName(contactId, firstNameTest));
}

//test updating last name
@Test
void updateLastNameTest() throws Exception {
  ContactService service = new ContactService();
  service.newContact();
  service.updateLastName(service.getContactList().get(0).getContactId(), lastNameTest);
  assertEquals(lastNameTest, service.getContactList().get(0).getLastName());
  //error if last name is too long
  assertThrows(IllegalArgumentException.class,
               ()
                   -> service.updateLastName(service.getContactList().get(0).getContactId(), tooLongLastName));
  //error if last name is null
  assertThrows(IllegalArgumentException.class,
               ()
                   -> service.updateLastName(service.getContactList().get(0).getContactId(), null));
  assertThrows(Exception.class,
               () -> service.updateLastName(contactId, lastNameTest));
}


//test updating phone number
@Test
void updatePhoneNumberTest() throws Exception {
  ContactService service = new ContactService();
  service.newContact();
  service.updatePhoneNumber(service.getContactList().get(0).getContactId(), phoneNumberTest);
  assertEquals(phoneNumberTest,
               service.getContactList().get(0).getPhoneNumber());
  //error if phone number is too many characters
  assertThrows(IllegalArgumentException.class,
               ()
                   -> service.updatePhoneNumber(service.getContactList().get(0).getContactId(), tooLongPhoneNumber));
  //error if phone number not enough characters
  assertThrows(IllegalArgumentException.class,
               ()
                   -> service.updatePhoneNumber(service.getContactList().get(0).getContactId(), tooShortPhoneNumber));
  
  assertThrows(IllegalArgumentException.class,
      ()
          -> service.updatePhoneNumber(service.getContactList().get(0).getContactId(), contactId));
  //error if phone number is null 
  assertThrows(IllegalArgumentException.class,
               ()
                   -> service.updatePhoneNumber(service.getContactList().get(0).getContactId(), null));
  assertThrows(Exception.class,
               () -> service.updatePhoneNumber(contactId, lastNameTest));
}


//test updating address
@Test
void updateAddressTest() throws Exception {
  ContactService service = new ContactService();
  service.newContact();
  service.updateAddress(service.getContactList().get(0).getContactId(),
                        addressTest);
  assertEquals(addressTest, service.getContactList().get(0).getAddress());
  //Error if address is too long or null
  assertThrows(IllegalArgumentException.class,
               ()
                   -> service.updateAddress(service.getContactList().get(0).getContactId(), tooLongAddress));
  assertThrows(IllegalArgumentException.class,
               ()
                   -> service.updateAddress(service.getContactList().get(0).getContactId(), null));
  assertThrows(Exception.class,
               () -> service.updateAddress(contactId, addressTest));
}
}
