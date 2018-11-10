/**
 * 
 */
package ca.footeware.es.contacts.repositories;

import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import ca.footeware.es.contacts.models.Contact;

/**
 * @author footeware.ca
 *
 */
public interface ContactRepository extends ElasticsearchRepository<Contact, String> {

	/**
	 * Find a contact by its email.
	 * 
	 * @param email {@link String}
	 * @return {@link Optional}<{@link Contact}>
	 */
	Optional<Contact> findByEmail(String email);
}
