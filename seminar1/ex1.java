package seminar1;

/**
 * ex1: 1. Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
 */
public class ex1 {public static void main(String[] args) {
        int n = 5; // Задайте значение n
        System.out.println("Треугольное число " + n + " равно " + triangularNumber(n));
        System.out.println("Факториал " + n + " равен " + factorial(n));
    }

    // Метод для вычисления треугольного числа
    public static int triangularNumber(int n) {
        int triangularNumber = 0;
        for (int i = 1; i <= n; i++) {
            triangularNumber += i;
        }
        return triangularNumber;
    }

    // Метод для вычисления факториала
    public static int factorial(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
