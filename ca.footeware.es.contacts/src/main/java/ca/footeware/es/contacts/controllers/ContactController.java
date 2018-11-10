/**
 * 
 */
package ca.footeware.es.contacts.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import ca.footeware.es.contacts.models.Contact;
import ca.footeware.es.contacts.services.ContactService;

/**
 * @author footeware.ca
 *
 */
@Controller
public class ContactController {

	private ContactService service;

	@Autowired
	public ContactController(ContactService service) {
		this.service = service;
	}

	@GetMapping("/")
	public String getContacts(Model model) {
		model.addAttribute("contacts", service.getContacts());
		return "contacts";
	}

	@GetMapping("/contacts/add")
	public String addContact(Model model) {
		model.addAttribute("contact", new Contact());
		return "contactEditor";
	}

	@PostMapping("/contacts/")
	public String addContact(@ModelAttribute("contact") Contact contact, Model model) {
		Assert.hasText(contact.getFirstName(), "First name cannot be empty.");
		Assert.hasText(contact.getLastName(), "Last name cannot be empty.");
		Assert.hasText(contact.getEmail(), "Email cannot be empty.");
		Contact addedContact = service.addContact(contact);
		Assert.notNull(addedContact, "Contact was not added.");
		return getContacts(model);
	}

	@DeleteMapping("/contacts/{id}")
	public String deleteContact(@PathVariable String id, Model model) {
		service.delete(id);
		return getContacts(model);
	}

	@PutMapping("/contacts/{id}")
	public String editContact(@PathVariable String id, Model model) {
		Optional<Contact> contact = service.getById(id);
		if (contact.isPresent()) {
			model.addAttribute("contact", contact.get());
		} else {
			throw new RuntimeException("Contact not found.");
		}
		return "contactEditor";
	}

}
