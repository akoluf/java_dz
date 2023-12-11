package seminar2;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ex2 {

    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(array);
    }

    // Метод для реализации пузырьковой сортировки
    public static void bubbleSort(int[] array) {
        int n = array.length;
        try (PrintWriter writer = new PrintWriter(new FileWriter("log.txt"))) {
            for (int i = 0; i < n-1; i++) {
                for (int j = 0; j < n-i-1; j++) {
                    if (array[j] > array[j+1]) {
                        // Обмен array[j+1] и array[j]
                        int temp = array[j];
                        array[j] = array[j+1];
                        array[j+1] = temp;
                    }
                }
                // Запись состояния массива в файл
                for (int k = 0; k < n; k++) {
                    writer.print(array[k] + " ");
                }
                writer.println();
            }
        } catch (IOException ex) {
            System.out.println("Ошибка записи в файл: " + ex.getMessage());
        }
    }
}
