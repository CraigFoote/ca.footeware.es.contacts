/**
 * 
 */
package ca.footeware.es.contacts.tests;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ca.footeware.es.contacts.exceptions.ContactNotFoundException;

/**
 * @author footeware.ca
 *
 */
class ContactNotFoundExceptionTests {

	/**
	 * Test method for
	 * {@link ca.footeware.es.contacts.tests.exceptions.ContactNotFoundException#ContactNotFoundException()}.
	 */
	@Test
	void testContactNotFoundException() {
		assertThrows(ContactNotFoundException.class, () -> {
			throw new ContactNotFoundException();
		});
	}

	/**
	 * Test method for
	 * {@link ca.footeware.es.contacts.tests.exceptions.ContactNotFoundException#ContactNotFoundException(java.lang.String)}.
	 */
	@Test
	void testContactNotFoundExceptionString() {
		assertThrows(ContactNotFoundException.class, () -> {
			throw new ContactNotFoundException("Test");
		});
	}

	/**
	 * Test method for
	 * {@link ca.footeware.es.contacts.tests.exceptions.ContactNotFoundException#ContactNotFoundException(java.lang.Throwable)}.
	 */
	@Test
	void testContactNotFoundExceptionThrowable() {
		assertThrows(ContactNotFoundException.class, () -> {
			throw new ContactNotFoundException(new Throwable());
		});
	}

	/**
	 * Test method for
	 * {@link ca.footeware.es.contacts.tests.exceptions.ContactNotFoundException#ContactNotFoundException(java.lang.String, java.lang.Throwable)}.
	 */
	@Test
	void testContactNotFoundExceptionStringThrowable() {
		assertThrows(ContactNotFoundException.class, () -> {
			throw new ContactNotFoundException("Test", new Throwable());
		});
	}

	/**
	 * Test method for
	 * {@link ca.footeware.es.contacts.tests.exceptions.ContactNotFoundException#ContactNotFoundException(java.lang.String, java.lang.Throwable, boolean, boolean)}.
	 */
	@Test
	void testContactNotFoundExceptionStringThrowableBooleanBoolean() {
		assertThrows(ContactNotFoundException.class, () -> {
			throw new ContactNotFoundException("Test", new Throwable(), false, false);
		});
	}

}
