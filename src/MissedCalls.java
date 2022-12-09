import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

public class MissedCalls {
    private final Map<MissedDateTime, String> missingCallMap = new TreeMap<>();

    public void addMissedCall(String number) {
        missingCallMap.put(new MissedDateTime(), number);
    }

    public void addMissedCall(LocalDateTime dateTime, String number) {
        missingCallMap.put(new MissedDateTime(dateTime), number);
    }

    public Map<MissedDateTime, String> getMissedCallMap() {
        return missingCallMap;
    }

    public String showWithPhoneBook(PhoneBook phoneBook) {
        StringBuilder sb = new StringBuilder();
        sb.append("Пропущенные вызовы: \n");
        sb.append(String.format("| %20s | %10s | %20s |",
                "Дата и время вызова", "Номер", "Контакт"));
        sb.append("\n");
        for (Map.Entry<MissedDateTime, String> entry : missingCallMap.entrySet()) {
            Contact contact = phoneBook.findByNumber(entry.getValue());
            if (contact == null) {
                contact = new Contact("Unknown", "", entry.getKey().toString());
            }
            String contactInfo = contact.toString();
            sb.append(String.format("| %20s | %10s | %20s |",
                    entry.getKey().toString(),
                    entry.getValue(),
                    contactInfo));
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<MissedDateTime, String> entry : missingCallMap.entrySet()) {
            sb.append(entry.getKey() + "\t\tНомер: " + entry.getValue() + "\n");
        }
        return sb.toString();
    }
}
