/**
 * 
 */
package ca.footeware.es.contacts.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ca.footeware.es.contacts.models.Contact;

/**
 * @author footeware.ca
 *
 */
class ContactTests {

	/**
	 * Test method for {@link ca.footeware.es.contacts.models.Contact#toString()}.
	 */
	@Test
	void testToString() {
		Contact contact = new Contact();
		contact.setFirstName("Craig");
		contact.setLastName("Foote");
		contact.setEmail("CraigFoote@gmail.com");
		String toString = contact.toString();
		assertEquals("Contact[id='null', firstName='Craig', lastName='Foote', email='CraigFoote@gmail.com']", toString);
	}

}
