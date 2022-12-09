import java.util.ArrayList;
import java.util.List;

public class GroupList {
    private List<Contact> contactList = new ArrayList<>();

    public void addContact(Contact contact) {
        contactList.add(contact);
    }

    public Contact findByName(String name) {
        for (Contact contact : contactList) {
            if (contact.getFirstName().equals(name) ||
                    contact.getLastName().equals(name) ||
                    (contact.getFirstName() + " " + contact.getLastName()).equals(name)) {
                return contact;
            }
        }
        return null;
    }

    public Contact findByNumber(String number) {
        for (Contact contact : contactList) {
            if (contact.getNumber().equals(number)) {
                return contact;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Contact contact : contactList) {
            result.append(contact.toString() + "\n");
        }
        return result.toString();
    }
}
