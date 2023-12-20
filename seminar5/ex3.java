/*
Необходимо разработать программу для сортировки массива целых чисел с использованием сортировки кучей (Heap Sort).
Программа должна работать следующим образом:
Принимать на вход массив целых чисел для сортировки. Если массив не предоставлен,
программа использует массив по умолчанию.
Сначала выводить исходный массив на экран.
Затем применять сортировку кучей (Heap Sort) для сортировки элементов массива в порядке возрастания.
Выводить отсортированный массив на экран.
Ваше решение должно содержать два основных метода: buildTree, который строит сортирующее
дерево на основе массива, и heapSort, который выполняет собственно сортировку кучей.
Программа должна быть способной сортировать массив, даже если он состоит из отрицательных
чисел и имеет дубликаты.
На входе:
'5 8 12 3 6 9'
 */
import java.util.Arrays;

public class ex3 {
    public static void main(String[] args) {
        // Используем массив по умолчанию для сортировки, если массив не предоставлен
        int[] numbers = {5, 8, 12, 3, 6, 9};

        // Выводим исходный массив на экран
        System.out.println("Исходный массив: " + Arrays.toString(numbers));

        // Применяем сортировку кучей для сортировки элементов массива
        heapSort(numbers);

        // Выводим отсортированный массив на экран
        System.out.println("Отсортированный массив: " + Arrays.toString(numbers));
    }

    public static void heapSort(int[] numbers) {
        int n = numbers.length;

        // Строим дерево сортировки
        for (int i = n / 2 - 1; i >= 0; i--) {
            buildTree(numbers, i, n);
        }

        // Выполняем сортировку кучей
        for (int i = n - 1; i >= 0; i--) {
            // Перемещаем максимальный элемент дерева на позицию i
            int temp = numbers[0];
            numbers[0] = numbers[i];
            numbers[i] = temp;

            // Обновляем дерево после перемещения максимального элемента
            buildTree(numbers, 0, i);
        }
    }

    public static void buildTree(int[] numbers, int i, int n) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Проверяем, есть ли левый и правый потомки
        if (left < n && numbers[left] > numbers[largest]) {
            largest = left;
        }

        if (right < n && numbers[right] > numbers[largest]) {
            largest = right;
        }

        // Если самый большой элемент не является корнем, обновляем его местоположение
        if (largest != i) {
            int temp = numbers[i];
            numbers[i] = numbers[largest];
            numbers[largest] = temp;

            // Обновляем дерево после обмена
            buildTree(numbers, largest, n);
        }
    }
}
