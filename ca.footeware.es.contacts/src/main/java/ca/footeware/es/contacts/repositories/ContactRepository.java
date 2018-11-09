/**
 * 
 */
package ca.footeware.es.contacts.repositories;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import ca.footeware.es.contacts.models.Contact;

/**
 * @author footeware.ca
 *
 */
public interface ContactRepository extends ElasticsearchRepository<Contact, String> {
}
