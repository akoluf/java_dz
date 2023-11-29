package seminar1;

import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первое число:");
        double num1 = scanner.nextDouble();

        System.out.println("Введите второе число:");
        double num2 = scanner.nextDouble();

        System.out.println("Введите операцию (+, -, *, /):");
        char operation = scanner.next().charAt(0);

        scanner.close();
        double result;

        switch(operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Ошибка: Деление на ноль!");
                    return;
                }
                break;
            default:
                System.out.println("Ошибка: Неверная операция!");
                return;
        }

        System.out.println("Результат: " + result);
    }
}
