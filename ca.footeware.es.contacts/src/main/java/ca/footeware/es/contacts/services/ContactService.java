/**
 * 
 */
package ca.footeware.es.contacts.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import ca.footeware.es.contacts.models.Contact;
import ca.footeware.es.contacts.repositories.ContactRepository;

/**
 * Exposes methods on {@link ContactRepository}
 * 
 * @author footeware.ca
 */
@Service
public class ContactService {

	private ContactRepository repository;

	/**
	 * Constructor.
	 * 
	 * @param repository {@link ContactRepository} injected
	 */
	@Autowired
	public ContactService(ContactRepository repository) {
		this.repository = repository;
	}

	/**
	 * Save a new or edited contact.
	 * 
	 * @param newContact {@link Contact}
	 * @return {@link Contact}
	 */
	public Contact saveContact(Contact newContact) {
		Assert.notNull(newContact, "Provided contact cannot be null.");
		Optional<Contact> byEmail = repository.findByEmail(newContact.getEmail());
		if (byEmail.isPresent()) {
			throw new RuntimeException("Provided contact's email address already exists.");
		}
		return repository.save(newContact);
	}

	/**
	 * Get all contacts.
	 * 
	 * @return {@link Iterable}<{@link Contact}
	 */
	public Iterable<Contact> getContacts() {
		return repository.findAll();
	}

	/**
	 * Delete a contact by its id.
	 * 
	 * @param id {@link String}
	 */
	public void delete(String id) {
		repository.deleteById(id);
	}

	/**
	 * Get a contact by its id.
	 * 
	 * @param id {@link String}
	 * @return {@link Optional}<{@link Contact}>
	 */
	public Optional<Contact> getById(String id) {
		return repository.findById(id);
	}
}
