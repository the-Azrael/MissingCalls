import java.time.LocalDateTime;

public class Main {
    private static final PhoneBook myPhoneBook = new PhoneBook("Ivan Ivanov");
    private static final MissedCalls myMissedCalls = new MissedCalls();

    public static void fillPhoneBook() {
        Contact wife = new Contact("Honey", "", "33-44-55");
        Contact sister = new Contact("Tatyana", "Ivanova", "11-11-11");
        Contact brother = new Contact("Petr", "Ivanov", "11-21-12");
        myPhoneBook.addContact("Family", wife);
        myPhoneBook.addContact("Family", sister);
        myPhoneBook.addContact("Family", brother);
    }

    public static void fillMissedCalls() {
        myMissedCalls.addMissedCall(LocalDateTime.of(2022, 3, 23, 12, 12, 12), "22-22-22");
        myMissedCalls.addMissedCall(LocalDateTime.of(2022, 3, 23, 13, 22, 22), "11-21-12");
        myMissedCalls.addMissedCall(LocalDateTime.of(2022, 3, 23, 13, 45, 01), "11-11-11");
        myMissedCalls.addMissedCall("33-44-55");
    }

    public static void main(String[] args) {
        fillPhoneBook();
        fillMissedCalls();
        System.out.println(myMissedCalls.showWithPhoneBook(myPhoneBook));
    }
}
