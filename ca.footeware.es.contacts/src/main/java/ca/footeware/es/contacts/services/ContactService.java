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
 * @author footeware.ca
 *
 */
@Service
public class ContactService {

	private ContactRepository repository;
	
	@Autowired
	public ContactService(ContactRepository repository) {
		this.repository = repository;
	}

	public Contact addContact(Contact newContact) {
		Assert.notNull(newContact, "Provided contact cannot be null.");
		Contact saved = repository.save(newContact);
		return saved;
	}

	public Iterable<Contact> getContacts() {
		Iterable<Contact> all = repository.findAll();
		return all;
	}

	public void delete(String id) {
		repository.deleteById(id);
	}

	public Optional<Contact> getById(String id) {
		return repository.findById(id);
	}
}
