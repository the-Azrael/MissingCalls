import java.util.*;

public class PhoneBook {
    private String name;
    private Set<String> groups = new HashSet<>();
    private Map<String, GroupList> contactsMap = new HashMap<>();

    public PhoneBook(String name) {
        this.name = name;
    }

    public void addGroup(String name) {
        groups.add(name);
    }

    public void addContact(String name, Contact contact) {
        addGroup(name);
        GroupList cl = contactsMap.get(name);
        if (cl == null) {
            cl = new GroupList();
        }
        cl.addContact(contact);
        contactsMap.put(name, cl);
    }

    public void addContactList(String name, GroupList list) {
        addGroup(name);
        contactsMap.put(name, list);
    }

    public Contact findByGroupAndName(String groupName, String name) {
        GroupList list = contactsMap.get(groupName);
        Contact contact = list.findByName(name);
        return contact;
    }

    public Contact findByNumber(String number) {
        for (Map.Entry<String, GroupList> group : contactsMap.entrySet()) {
            GroupList list = group.getValue();
            Contact contact = list.findByNumber(number);
            if (contact != null) {
                return contact;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("--- " + this.name + "'s Phone Book ----" + "\n");
        result.append("---------------------------------------------\n");
        for (Map.Entry<String, GroupList> entry : contactsMap.entrySet()) {
            result.append("Группа: " + entry.getKey() + "\n");
            result.append(entry.getValue());

        }
        result.append("---------------------------------------------\n");
        return result.toString();
    }
}
