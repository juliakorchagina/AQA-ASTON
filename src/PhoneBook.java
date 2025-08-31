import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<String>> phoneBook = new HashMap<>();
    public void add(String surname, String phone) {
        if (!phoneBook.containsKey(surname)) {
            phoneBook.put(surname, new ArrayList<>());
        }
        phoneBook.get(surname).add(phone);
    }
    public void get(String surname) {
        List<String> phones = phoneBook.get(surname);
        if (phones != null) {
            System.out.println(surname + " - " + phones);
        } else {
            System.out.println("Фамилия " + surname + " не найдена");
        }
    }
}
