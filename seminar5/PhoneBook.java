/**
Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1
человек может иметь несколько телефонов.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
    private Map<String, List<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void add(String name, List<String> phoneNums) {
        phoneBook.put(name, phoneNums);
    }

    public List<String> find(String name) {
        return phoneBook.getOrDefault(name, new ArrayList<>());
    }

    public void edit(String name, String oldPhoneNum, String newPhoneNum) {
        List<String> phoneNums = phoneBook.get(name);
        if (phoneNums != null) {
            int index = phoneNums.indexOf(oldPhoneNum);
            if (index != -1) {
                phoneNums.set(index, newPhoneNum);
            }
        }
    }

    public void remove(String name) {
        phoneBook.remove(name);
    }

    public void removePhone(String name, String phoneNum) {
        List<String> phoneNums = phoneBook.get(name);
        if (phoneNums != null) {
            phoneNums.remove(phoneNum);
        }
    }

    public void viewAllContacts() {
        for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
            String name = entry.getKey();
            List<String> phoneNums = entry.getValue();
            System.out.println("Контакт: " + name);
            System.out.println("Номера телефона:");
            for (String phoneNum : phoneNums) {
                System.out.println(phoneNum);
            }
            System.out.println();
        }
    }

    public void editPhoneNumbers(String name, List<String> newPhoneNums) {
        phoneBook.put(name, newPhoneNums);
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        scanner.close();

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить контакт");
            System.out.println("2. Искать контакт");
            System.out.println("3. Редактировать номер телефона контакта");
            System.out.println("4. Удалить контакт");
            System.out.println("5. Удалить номер телефона для контакта");
            System.out.println("6. Вывести все контакты");
            System.out.println("0. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Чтение символа новой строки после ввода числа

            if (choice == 0) {
                break;
            }

            switch (choice) {
                case 1:
                    System.out.println("Введите имя контакта:");
                    String name = scanner.nextLine();
                    List<String> phoneNums = new ArrayList<>();
                    while (true) {
                        System.out.println("Введите номер телефона (или 'конец' для завершения):");
                        String phoneNum = scanner.nextLine();
                        if (phoneNum.equals("конец")) {
                            break;
                        }
                        phoneNums.add(phoneNum);
                    }
                    phoneBook.add(name, phoneNums);
                    System.out.println("Контакт добавлен");
                    break;
                case 2:
                    System.out.println("Введите имя контакта для поиска:");
                    String searchName = scanner.nextLine();

                    List<String> phoneNumbers = phoneBook.find(searchName);
                    if (phoneNumbers.isEmpty()) {
                        System.out.println("Контакт не найден");
                    } else {
                        System.out.println("Номера телефона для контакта " + searchName + ":");
                        for (String phoneNumber : phoneNumbers) {
                            System.out.println(phoneNumber);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Введите имя контакта для редактирования:");
                    String editName = scanner.nextLine();
                    List<String> editPhoneNums = phoneBook.find(editName);
                    if (editPhoneNums.isEmpty()) {
                        System.out.println("Контакт не найден");
                    } else {
                        System.out.println("Номера телефона для контакта " + editName + ":");
                        for (int i = 0; i < editPhoneNums.size(); i++) {
                            System.out.println(i + 1 + ". " + editPhoneNums.get(i));
                        }
                        System.out.println("Введите номер номера телефона для редактирования:");
                        int editPhoneIndex = scanner.nextInt();
                        scanner.nextLine(); // Чтение символа новой строки после ввода числа
                        System.out.println("Введите новый номер телефона:");
                        String newPhoneNumber = scanner.nextLine();

                        phoneBook.edit(editName, editPhoneNums.get(editPhoneIndex - 1), newPhoneNumber);
                        System.out.println("Номер телефона отредактирован");
                    }
                    break;
                case 4:
                    System.out.println("Введите имя контакта для удаления:");
                    String removeName = scanner.nextLine();

                    phoneBook.remove(removeName);
                    System.out.println("Контакт удален");
                    break;
                case 5:
                    System.out.println("Введите имя контакта:");
                    String removePhoneName = scanner.nextLine();
                    List<String> removePhoneNums = phoneBook.find(removePhoneName);
                    if (removePhoneNums.isEmpty()) {
                        System.out.println("Контакт не найден");
                    } else {
                        System.out.println("Номера телефона для контакта " + removePhoneName + ":");
                        for (int i = 0; i < removePhoneNums.size(); i++) {
                            System.out.println(i + 1 + ". " + removePhoneNums.get(i));
                        }
                        System.out.println("Введите номер номера телефона для удаления:");
                        int removePhoneIndex = scanner.nextInt();
                        scanner.nextLine(); // Чтение символа новой строки после ввода числа

                        phoneBook.removePhone(removePhoneName, removePhoneNums.get(removePhoneIndex - 1));
                        System.out.println("Номер телефона удален");
                    }
                    break;
                case 6:
                    phoneBook.viewAllContacts();
                    break;
                default:
                    System.out.println("Некорректный выбор");
                    break;
            }
            System.out.println();
        }
    }
}
