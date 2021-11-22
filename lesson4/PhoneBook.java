package lesson4;

import java.util.ArrayList;
import java.util.HashMap;
public class PhoneBook {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Потанин", "+7-911-337-02-07");
        phoneBook.add("Лисин", "+7-900-508-99-15");
        phoneBook.add("Михельсон", "+7-921-411-81-66");
        phoneBook.add("Мордашов", "+7-905-463-79-31");
        phoneBook.add("Алекперов", "+7-999-466-34-46");
        phoneBook.add("Тимченко", "+7-906-138-22-23");
        phoneBook.add("Усманов", "+7-904-666-13-66");
        phoneBook.add("Фридман", "+7-949-388-67-48");
        phoneBook.add("Мельниченко", "+7-900-097-27-99");
        phoneBook.add("Абрамович", "+7-926-507-38-93");
        phoneBook.add("Мордашов", "+7-999-001-11-00");
        System.out.println("Поиск по фамилии - Усманов\n" + phoneBook.get("Усманов"));
        System.out.println("Поиск по фамилии - Мордашов\n" + phoneBook.get("Мордашов"));
    }
    private final HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();
    public void add(String lastName, String phoneNumber) {
        ArrayList<String> phonesForLastName = phoneBook.getOrDefault(lastName, new ArrayList<>());
        phonesForLastName.add(phoneNumber);
        phoneBook.put(lastName, phonesForLastName);
    }
    public ArrayList<String> get(String lastName) {
        return phoneBook.get(lastName);
    }
}