/**
 * 
 */
package ca.footeware.es.contacts.models;

/**
 * The data transfer object.
 * 
 * @author footeware.ca
 */
public class ContactDTO {

	private String id;
	private String firstName;
	private String lastName;
	private String email;

	/**
	 * Default constructor.
	 */
	public ContactDTO() {
		// nothing to do
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("Contact[id='%s', firstName='%s', lastName='%s', email='%s']", id, firstName, lastName,
				email);
	}

}
