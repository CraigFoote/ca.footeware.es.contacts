/**
 * 
 */
package ca.footeware.es.contacts.tests.it;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import ca.footeware.es.contacts.controllers.ContactController;
import ca.footeware.es.contacts.models.Contact;
import ca.footeware.es.contacts.services.ContactService;

/**
 * @author footeware.ca
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ContactControllerIT {

	@Autowired
	private ContactService service;

	@Autowired
	private TestRestTemplate template;

	@BeforeEach
	public void setup() {
		Iterable<Contact> contacts = service.getContacts();
		for (Contact contact : contacts) {
			service.delete(contact.getId());
		}
	}

	/**
	 * Test method for
	 * {@link ca.footeware.es.contacts.tests.controllers.ContactController#ContactController(ca.footeware.es.contacts.tests.services.ContactService)}.
	 */
	@Test
	void testContactController() {
		ContactController controller = new ContactController(service);
		assertNotNull(controller);
	}

	/**
	 * Test method for
	 * {@link ca.footeware.es.contacts.tests.controllers.ContactController#getContacts(org.springframework.ui.Model)}.
	 * 
	 * @throws Exception
	 */
	@Test
	void testGetContacts() throws Exception {
		String contactsPage = template.getForObject("/", String.class);
		Document document = Jsoup.parse(contactsPage);
		Element h1 = document.selectFirst("body header h1");
		assertEquals("Contacts", h1.text());
	}

	/**
	 * Test method for
	 * {@link ca.footeware.es.contacts.tests.controllers.ContactController#addContact(org.springframework.ui.Model)}.
	 */
	@Test
	void testAddContact() {
		String contactEditor = template.getForObject("/contacts/add", String.class);
		Document document = Jsoup.parse(contactEditor);
		Element h1 = document.selectFirst("body header h1");
		assertEquals("Contact Editor", h1.text());
	}

	/**
	 * Test method for
	 * {@link ca.footeware.es.contacts.tests.controllers.ContactController#saveContact(ca.footeware.es.contacts.tests.models.Contact, org.springframework.ui.Model)}.
	 */
	@Test
	void testSaveContact() {
		String url = "/contacts?firstName=Craig&lastName=Foote&email=CraigFoote@gmail.com";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<String> response = template.exchange(url, HttpMethod.POST, entity, String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		Document document = Jsoup.parse(response.getBody());
		Element h1 = document.selectFirst("body header h1");
		assertEquals("Contacts", h1.text());
		Elements elements = document.select("ol li");
		assertEquals(1, elements.size());
	}

	/**
	 * Test method for
	 * {@link ca.footeware.es.contacts.tests.controllers.ContactController#deleteContact(java.lang.String, org.springframework.ui.Model)}.
	 */
	@Test
	void testDeleteContact() {
		String url = "/contacts?firstName=Craig&lastName=Foote&email=CraigFoote@gmail.com";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<String> response = template.exchange(url, HttpMethod.POST, entity, String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		Document document = Jsoup.parse(response.getBody());
		Element editImg = document.selectFirst("li div img");
		String id = editImg.attr("id");
		assertNotNull(id);

		template.delete("/contacts/" + id);

		String contactsPage = template.getForObject("/", String.class);
		document = Jsoup.parse(contactsPage);
		Element li = document.selectFirst("li");
		assertTrue(li == null);
	}

	/**
	 * Test method for
	 * {@link ca.footeware.es.contacts.tests.controllers.ContactController#editContact(java.lang.String, org.springframework.ui.Model)}.
	 */
	@Test
	void testEditContact() {
		String url = "/contacts?firstName=Craig&lastName=Foote&email=CraigFoote@gmail.com";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<String> response = template.exchange(url, HttpMethod.POST, entity, String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		Document document = Jsoup.parse(response.getBody());
		Element editImg = document.selectFirst("li div img");
		String id = editImg.attr("id");
		assertNotNull(id);

		url = "/contacts/" + id;
		headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		entity = new HttpEntity<>(headers);
		response = template.exchange(url, HttpMethod.PUT, entity, String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		document = Jsoup.parse(response.getBody());
		Element h1 = document.selectFirst("body header h1");
		assertEquals("Contact Editor", h1.text());

		// invalid ID
		url = "/contacts/1";
		headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		entity = new HttpEntity<>(headers);
		response = template.exchange(url, HttpMethod.PUT, entity, String.class);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
		document = Jsoup.parse(response.getBody());
		String body = document.selectFirst("body").text();
		assertTrue(body.contains("Contact not found."));
	}

}
