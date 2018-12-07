/**
 * 
 */
package ca.footeware.es.contacts.tests;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ca.footeware.es.contacts.exceptions.ContactException;

/**
 * @author footeware.ca
 *
 */
class ContactExceptionTests {

	/**
	 * Test method for
	 * {@link ca.footeware.es.contacts.tests.exceptions.ContactException#ContactException()}.
	 */
	@Test
	void testContactException() {
		assertThrows(ContactException.class, () -> {
			throw new ContactException();
		});
	}

	/**
	 * Test method for
	 * {@link ca.footeware.es.contacts.tests.exceptions.ContactException#ContactException(java.lang.String)}.
	 */
	@Test
	void testContactExceptionString() {
		assertThrows(ContactException.class, () -> {
			throw new ContactException("Test");
		});
	}

	/**
	 * Test method for
	 * {@link ca.footeware.es.contacts.tests.exceptions.ContactException#ContactException(java.lang.Throwable)}.
	 */
	@Test
	void testContactExceptionThrowable() {
		assertThrows(ContactException.class, () -> {
			throw new ContactException(new Throwable());
		});
	}

	/**
	 * Test method for
	 * {@link ca.footeware.es.contacts.tests.exceptions.ContactException#ContactException(java.lang.String, java.lang.Throwable)}.
	 */
	@Test
	void testContactExceptionStringThrowable() {
		assertThrows(ContactException.class, () -> {
			throw new ContactException("Test", new Throwable());
		});
	}

	/**
	 * Test method for
	 * {@link ca.footeware.es.contacts.tests.exceptions.ContactException#ContactException(java.lang.String, java.lang.Throwable, boolean, boolean)}.
	 */
	@Test
	void testContactExceptionStringThrowableBooleanBoolean() {
		assertThrows(ContactException.class, () -> {
			throw new ContactException("Test", new Throwable(), false, false);
		});
	}

}
