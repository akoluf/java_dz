package seminar2;

import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;

public class ex4 {
    private static final Logger logger = Logger.getLogger(ex3.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        logger.log(Level.INFO, "Запуск программы");

        System.out.println("Введите первое число:");
        double num1 = scanner.nextDouble();
        logger.log(Level.INFO, "Первое число: " + num1);

        System.out.println("Введите второе число:");
        double num2 = scanner.nextDouble();
        logger.log(Level.INFO, "Второе число: " + num2);

        System.out.println("Введите операцию (+, -, *, /):");
        char operation = scanner.next().charAt(0);
        logger.log(Level.INFO, "Операция: " + operation);

        scanner.close();
        double result;

        switch(operation) {
            case '+':
                result = num1 + num2;
                logger.log(Level.INFO, "Операция сложения");
                break;
            case '-':
                result = num1 - num2;
                logger.log(Level.INFO, "Операция вычитания");
                break;
            case '*':
                result = num1 * num2;
                logger.log(Level.INFO, "Операция умножения");
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                    logger.log(Level.INFO, "Операция деления");
                } else {
                    logger.log(Level.SEVERE, "Ошибка: Деление на ноль!");
                    System.out.println("Ошибка: Деление на ноль!");
                    return;
                }
                break;
            default:
                logger.log(Level.SEVERE, "Ошибка: Недопустимая операция!");
                System.out.println("Ошибка: Неверная операция!");
                return;
        }

        System.out.println("Результат: " + result);
        logger.log(Level.INFO, "Результат: " + result);
    }
}
