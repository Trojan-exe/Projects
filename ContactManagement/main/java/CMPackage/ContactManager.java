package CMPackage;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContactManager {

	public Map<String, Contact> contactList = new ConcurrentHashMap<String, Contact>();

	public void addContact(String firstName, String lastName, String phoneNumber) {
		Contact contact = new Contact(firstName, lastName, phoneNumber);
		validateContact(contact);
		checkIfContactAlreadyExist(contact);
		contactList.put(generateKey(contact), contact);
	}
	
	public void deleteContact(Contact contact) {
		this.contactList.remove(generateKey(contact));
	}

	public Collection<Contact> getAllContacts() {
		return contactList.values();
	}

	public void checkIfContactAlreadyExist(Contact contact) {
		if (contactList.containsKey(generateKey(contact)))
			throw new RuntimeException("Contact Already Exists");
	}

	public boolean isPresent(Contact contact) {
		if (contactList.containsKey(generateKey(contact)))
			return true;
		else
			return false;
	}

	public static boolean isFirstNameValid(Contact contact) {
		try {
			contact.validateFirstName();
			return true;
		} catch (RuntimeException re) {
			return false;
		}
	}

	public static boolean isLastNameValid(Contact contact) {
		try {
			contact.validateLastName();
			return true;
		} catch (RuntimeException re) {
			return false;
		}
	}

	public static boolean isPhoneValid(Contact contact) {
		try {
			contact.validatePhoneNumber();
			return true;
		} catch (RuntimeException re) {
			return false;
		}
	}

	private void validateContact(Contact contact) {
		contact.validateFirstName();
		contact.validateLastName();
		contact.validatePhoneNumber();
	}

	private String generateKey(Contact contact) {
		return String.format("%s-%s", contact.getFirstName(), contact.getLastName());
	}

}
