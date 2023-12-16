/**
Реализовать алгоритм сортировки слиянием. a = {5, 1, 6, 2, 3, 4}
 */
public class ex1 {

    // Метод для слияния двух отсортированных массивов
    void merge(int arr[], int l, int m, int r) {
        // Размеры двух подмассивов для слияния
        int n1 = m - l + 1;
        int n2 = r - m;

        // Создание временных массивов
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Копирование данных в временные массивы
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];

        // Слияние временных массивов
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Копирование оставшихся элементов L[], если таковые есть
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Копирование оставшихся элементов R[], если таковые есть
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Основной метод, который сортирует arr[l..r] с помощью merge()
    void sort(int arr[], int l, int r) {
        if (l < r) {
            // Найдите середину
            int m = (l+r)/2;

            // Сортировка первой и второй половины
            sort(arr, l, m);
            sort(arr , m+1, r);

            // Слияние отсортированных половин
            merge(arr, l, m, r);
        }
    }

    // Метод для вывода массива на экран
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Тест
    public static void main(String args[]) {
        int arr[] = {5, 1, 6, 2, 3, 4};

        System.out.println("Исходный массив");
        printArray(arr);

        ex1 ob = new ex1();
        ob.sort(arr, 0, arr.length-1);

        System.out.println("\nОтсортированный массив");
        printArray(arr);
    }
}
