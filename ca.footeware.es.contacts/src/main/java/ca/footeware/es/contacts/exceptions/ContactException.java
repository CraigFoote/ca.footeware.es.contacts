/**
 * 
 */
package ca.footeware.es.contacts.exceptions;

/**
 * @author footeware.ca
 *
 */
public class ContactException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public ContactException() {
		super();
	}

	/**
	 * @param message
	 */
	public ContactException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ContactException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ContactException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ContactException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
