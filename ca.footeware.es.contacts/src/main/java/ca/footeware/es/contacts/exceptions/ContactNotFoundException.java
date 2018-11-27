/**
 * 
 */
package ca.footeware.es.contacts.exceptions;

/**
 * @author footeware.ca
 *
 */
public class ContactNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public ContactNotFoundException() {
		super();
	}

	/**
	 * @param message
	 */
	public ContactNotFoundException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ContactNotFoundException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ContactNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ContactNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
