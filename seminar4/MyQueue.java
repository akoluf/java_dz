/**
Реализуйте очередь с помощью LinkedList со следующими методами:
enqueue() - помещает элемент в конец очереди, dequeue() - возвращает первый элемент
из очереди и удаляет его, first() - возвращает первый элемент из очереди, не удаляя.
 */
import java.util.LinkedList;

public class MyQueue {
    private LinkedList<Integer> queue;

    public MyQueue() {
        queue = new LinkedList<>(); // Создаем новый экземпляр LinkedList для хранения элементов очереди
    }

    public void enqueue(Integer element) {
        queue.addLast(element); // Добавляем элемент в конец списка
    }

    public Integer dequeue() {
        return queue.pollFirst(); // Извлекаем и возвращаем первый элемент списка, удаляя его из очереди
    }

    public Integer first() {
        return queue.peekFirst(); // Возвращаем первый элемент списка, не удаляя его из очереди
    }

    public LinkedList<Integer> getElements() {
        return queue; // Возвращаем LinkedList, содержащий все элементы очереди
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();

        myQueue.enqueue(1); // Добавляем элемент 1 в очередь
        myQueue.enqueue(2); // Добавляем элемент 2 в очередь
        myQueue.enqueue(3); // Добавляем элемент 3 в очередь
        myQueue.enqueue(4); // Добавляем элемент 4 в очередь

        System.out.println("Элементы в очереди: " + myQueue.getElements());

        Integer firstElement = myQueue.dequeue(); // Извлекаем и удаляем первый элемент из очереди
        System.out.println("Первый элемент: " + firstElement);

        Integer firstWithoutDeletion = myQueue.first(); // Получаем первый элемент без удаления из очереди
        System.out.println("Первый элемент без удаления: " + firstWithoutDeletion);
    }
}
