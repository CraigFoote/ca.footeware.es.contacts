/**
 * 
 */
package ca.footeware.es.contacts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import ca.footeware.es.contacts.models.Contact;
import ca.footeware.es.contacts.repositories.ContactRepository;
import ca.footeware.es.contacts.services.ContactService;

/**
 * @author footeware.ca
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
class ContactServiceTests {

	@Autowired
	private ContactService service;

	@Autowired
	private ContactRepository repository;

	private Contact contact = new Contact();

	private Contact getContact() {
		contact.setFirstName("Craig");
		contact.setLastName("Foote");
		contact.setEmail("CraigFoote@gmail.com");
		return contact;
	}

	@BeforeEach
	void setup() {
		repository.deleteAll();
	}

	@AfterEach
	void tearDown() {
		repository.deleteAll();
	}

	/**
	 * Test method for
	 * {@link ca.footeware.es.contacts.services.ContactService#ContactService(ca.footeware.es.contacts.repositories.ContactRepository)}.
	 */
	@Test
	void testContactService() {
		ContactService service2 = new ContactService(repository);
		assertNotNull(service2);
	}

	/**
	 * Test method for
	 * {@link ca.footeware.es.contacts.services.ContactService#saveContact(ca.footeware.es.contacts.models.Contact)}.
	 */
	@Test
	void testSaveContact() {
		contact = service.saveContact(getContact());
		assertNotSame(null, contact.getId(), "Saved contact should have non-null id.");
	}

	/**
	 * Test method for
	 * {@link ca.footeware.es.contacts.services.ContactService#getContacts()}.
	 */
	@Test
	void testGetContacts() {
		contact = service.saveContact(getContact());
		Iterable<Contact> contacts = service.getContacts();
		int i = 0;
		Iterator<Contact> iterator = contacts.iterator();
		while (iterator.hasNext()) {
			i++;
			iterator.next();
		}
		assertEquals(1, i);
	}

	/**
	 * Test method for
	 * {@link ca.footeware.es.contacts.services.ContactService#delete(java.lang.String)}.
	 */
	@Test
	void testDelete() {
		Contact saveContact = service.saveContact(getContact());
		String id = saveContact.getId();
		service.delete(id);
		Optional<Contact> byId = service.getById(id);
		assertFalse(byId.isPresent());
	}

	/**
	 * Test method for
	 * {@link ca.footeware.es.contacts.services.ContactService#getById(java.lang.String)}.
	 */
	@Test
	void testGetById() {
		contact = service.saveContact(getContact());
		String id = contact.getId();
		Optional<Contact> optional = service.getById(id);
		assertTrue(optional.isPresent());
		assertEquals(id, ((Contact) optional.get()).getId());
	}

}