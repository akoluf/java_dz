/**
* В калькулятор добавьте возможность отменить последнюю операцию.
 */
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.io.IOException;

public class ex3 {
    private static final Logger logger = Logger.getLogger(ex3.class.getName());

    private static double previousResult = 0.0; // переменная для хранения предыдущего результата

    public static void main(String[] args) {
        FileHandler fh;

        try {
            fh = new FileHandler("myLogFile.log", true); // the true will append the new log to the existing file
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            // the following statement is used to log any messages
            logger.info("My first log");

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);

        logger.log(Level.INFO, "Starting the program");

        System.out.println("Введите первое число:");
        double num1 = scanner.nextDouble();
        logger.log(Level.INFO, "First number: " + num1);

        System.out.println("Введите второе число:");
        double num2 = scanner.nextDouble();
        logger.log(Level.INFO, "Second number: " + num2);

        System.out.println("Введите операцию (+, -, *, / или 'u' для отмены):");
        char operation = scanner.next().charAt(0);
        logger.log(Level.INFO, "Operation: " + operation);

        scanner.close();
        double result;

        switch(operation) {
            case '+':
                result = num1 + num2;
                logger.log(Level.INFO, "Addition operation");
                break;
            case '-':
                result = num1 - num2;
                logger.log(Level.INFO, "Subtraction operation");
                break;
            case '*':
                result = num1 * num2;
                logger.log(Level.INFO, "Multiplication operation");
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                    logger.log(Level.INFO, "Division operation");
                } else {
                    logger.log(Level.SEVERE, "Error: Division by zero!");
                    System.out.println("Ошибка: Деление на ноль!");
                    return;
                }
                break;
            case 'u': // проверка на отмену операции
                result = previousResult; // восстанавливаем предыдущий результат
                logger.log(Level.INFO, "Undo operation");
                break;
            default:
                logger.log(Level.SEVERE, "Error: Invalid operation!");
                System.out.println("Ошибка: Неверная операция!");
                return;
        }

        System.out.println("Результат: " + result);
        logger.log(Level.INFO, "Result: " + result);

        previousResult = result; // сохраняем текущий результат как предыдущий
    }
}
