package seminar6;

import java.util.*;

public class Notebook {
    private String model;
    private int RAM;
    private int HDD;
    private String operatingSystem;
    private String color;

    public Notebook(String model, int RAM, int HDD, String operatingSystem, String color) {
        this.model = model;
        this.RAM = RAM;
        this.HDD = HDD;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    // Геттеры и сеттеры

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public int getHDD() {
        return HDD;
    }

    public void setHDD(int HDD) {
        this.HDD = HDD;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public static void main(String[] args) {
        Set<Notebook> notebooks = new HashSet<>();

        // Добавляем ноутбуки в множество
        notebooks.add(new Notebook("Notebook1", 8, 500, "Windows", "Black"));
        notebooks.add(new Notebook("Notebook2", 16, 1000, "Linux", "Silver"));
        notebooks.add(new Notebook("Notebook3", 4, 256, "Windows", "White"));
        notebooks.add(new Notebook("Notebook4", 8, 512, "Mac", "Space Gray"));
        notebooks.add(new Notebook("Notebook5", 16, 1000, "Windows", "Black"));

        // Выполняем фильтрацию
        Map<String, Object> filters = getFiltersFromUser();
        Set<Notebook> filteredNotebooks = filterNotebooks(notebooks, filters);

        // Выводим отфильтрованные ноутбуки
        for (Notebook notebook : filteredNotebooks) {
            System.out.println(notebook.getModel());
        }
    }

    // Метод для получения критериев фильтрации от пользователя
    public static Map<String, Object> getFiltersFromUser() {
        Scanner scanner = new Scanner(System.in);

        Map<String, Object> filters = new HashMap<>();
        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        System.out.print("Выберите критерии фильтрации (через пробел): ");
        String input = scanner.nextLine();
        String[] criteria = input.split(" ");

        for (String criterion : criteria) {
            switch (criterion) {
                case "1":
                    System.out.print("Введите минимальное значение для ОЗУ: ");
                    int RAM = scanner.nextInt();
                    filters.put("RAM", RAM);
                    break;
                case "2":
                    System.out.print("Введите минимальное значение для объема ЖД: ");
                    int HDD = scanner.nextInt();
                    filters.put("HDD", HDD);
                    break;
                case "3":
                    System.out.print("Введите операционную систему: ");
                    String operatingSystem = scanner.next();
                    filters.put("operatingSystem", operatingSystem);
                    break;
                case "4":
                    System.out.print("Введите цвет: ");
                    String color = scanner.next();
                    filters.put("color", color);
                    break;
                default:
                    System.out.println("Неверный критерий фильтрации");
                    break;
            }
        }
        scanner.close();

        return filters;
    }

    // Метод для фильтрации ноутбуков по заданным критериям
    public static Set<Notebook> filterNotebooks(Set<Notebook> notebooks, Map<String, Object> filters) {
        Set<Notebook> filteredNotebooks = new HashSet<>();

        for (Notebook notebook : notebooks) {
            boolean passFilter = true;

            // Проверяем каждый критерий фильтрации
            for (Map.Entry<String, Object> entry : filters.entrySet()) {
                String criterion = entry.getKey();
                Object value = entry.getValue();

                switch (criterion) {
                    case "RAM":
                        if (notebook.getRAM() < (int) value) {
                            passFilter = false;
                        }
                        break;
                    case "HDD":
                        if (notebook.getHDD() < (int) value) {
                            passFilter = false;
                        }
                        break;
                    case "operatingSystem":
                        if (!notebook.getOperatingSystem().equals(value)) {
                            passFilter = false;
                        }
                        break;
                    case "color":
                        if (!notebook.getColor().equals(value)) {
                            passFilter = false;
                        }
                        break;
                    default:
                        break;
                }
            }

            if (passFilter) {
                filteredNotebooks.add(notebook);
            }
        }

        return filteredNotebooks;
    }
}
