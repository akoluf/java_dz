/*
Вы работаете с приложением для учета имен пользователей. Ваша задача - разработать программу, которая принимает на вход пять имен пользователей (или использует имена по умолчанию, если аргументы не предоставлены) и подсчитывает, сколько раз каждое имя встречается.
Программа должна использовать HashMap для хранения имен и их количества вхождений.
По завершении, программа выводит результат в виде пар "имя - количество".
*/

import java.util.HashMap;
import java.util.Map;

public class ex2 {
    public static void main(String[] args) {
        // Используем массив по умолчанию для хранения имен пользователей
        String[] names = {
                "Elena", "Elena", "Elena",
                "Ivan", "Ivan"
        };

        // Создаем объект HashMap для хранения имен и их количества вхождений
        HashMap<String, Integer> userCounter = new HashMap<>();

        // Проходимся по всем именам в массиве и обновляем счетчик
        for (String name : names) {
            userCounter.put(name, userCounter.getOrDefault(name, 0) + 1);
        }

        // Выводим результат в виде пар "имя - количество"
        for (Map.Entry<String, Integer> entry : userCounter.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
