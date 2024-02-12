package org.example.hw_phone_book;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<String, List<String>> phoneBook = new HashMap<>();

        /**
         * Запрос ввода у пользователя
         */

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите имя контакта, [ENTER] для выхода: ");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                break;
            }

            System.out.println("Введите номер телефона: ");
            String phoneNumber = scanner.nextLine();

            addContact(phoneBook, name, phoneNumber);

            printPhoneBook(phoneBook);
        }
    }

    /**
     * @param phoneBook   - коллекция, включающая имена и номера телефонов, введеные пользователем
     * @param name        - имя, вводимое пользователем
     * @param phoneNumber - телефонный номер, вводимый пользователем
     */

    public static void addContact(HashMap<String, List<String>> phoneBook, String name, String phoneNumber) {
        List<String> numbers = phoneBook.getOrDefault(name, new ArrayList<>());
        numbers.add(phoneNumber);
        phoneBook.put(name, numbers);
    }

    /**
     * @param phoneBook - создан список с записями телефонной книги
     */

    public static void printPhoneBook(HashMap<String, List<String>> phoneBook) {

        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(phoneBook.entrySet());


        entries.sort((a, b) -> b.getValue().size() - a.getValue().size()); // сортировка в порядке убывания


        for (Map.Entry<String, List<String>> entry : entries) { // вывод отсортированной телефонной книги
            String name = entry.getKey();
            List<String> numbers = entry.getValue();
            System.out.println(name + ": " + numbers);
        }
    }
}
