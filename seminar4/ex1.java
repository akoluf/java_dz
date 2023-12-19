/**
Дан LinkedList с несколькими элементами разного типа. В методе revert класса LLTasks реализуйте разворот этого списка без
использования встроенного функционала.
 */
import java.util.LinkedList;

public class ex1 {
    public static void main(String[] args) {
        LinkedList<Object> list = new LinkedList<>();
        list.add(1);
        list.add("One");
        list.add(2);
        list.add("Two");

        System.out.println("Исходный список: " + list);
        revert(list);
        System.out.println("Развернутый список: " + list);
    }

    public static void revert(LinkedList<Object> list) {
        int size = list.size();
        for (int i = 0; i < size / 2; i++) {
            Object temp = list.get(i);
            list.set(i, list.get(size - i - 1));
            list.set(size - i - 1, temp);
        }
    }
}
