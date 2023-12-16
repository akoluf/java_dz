/**
Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
исходный массив - [4, 2, 7, 5, 1, 3, 8, 6, 9]
 */
import java.util.ArrayList;
import java.util.Collections;

public class ex3 {
    public static void main(String[] args) {
        // Инициализация списка целых чисел
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, 4, 2, 7, 5, 1, 3, 8, 6, 9);

        // Нахождение минимального, максимального и среднего значений
        int min = Collections.min(list);
        int max = Collections.max(list);
        double average = list.stream().mapToInt(val -> val).average().orElse(0.0);

        // Вывод результатов
        System.out.println("Минимальное значение: " + min);
        System.out.println("Максимальное значение: " + max);
        System.out.println("Среднее значение: " + average);
    }
}
