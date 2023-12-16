/**
Дан произвольный массив целых чисел. Создайте список ArrayList, заполненный данными из этого массива. Необходимо удалить из списка четные числа и вернуть результирующий.
исходный массив - [1, 2, 3, 4, 5, 6, 7, 8, 9]
 */
import java.util.ArrayList;

public class ex2 {
    public static void main(String[] args) {
        // Исходный массив
        int[] originalArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        // Создание ArrayList из массива
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i : originalArray) {
            arrayList.add(i);
        }

        // Удаление четных чисел
        arrayList.removeIf(n -> (n % 2 == 0));

        // Вывод результата
        System.out.println(arrayList);
    }
}
