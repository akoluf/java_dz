/*
Дана json строка (можно сохранить в файл и читать из файла)
[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"
Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент
[фамилия] получил [оценка] по предмету [предмет].
Пример вывода:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.
*/

package seminar2;

import org.json.JSONArray;
import org.json.JSONObject;

public class ex3 {
    public static void main(String[] args) {
        String jsonString = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
        printStudentInfo(jsonString);
    }

    public static void printStudentInfo(String jsonString) {
        JSONArray jsonArray = new JSONArray(jsonString);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String фамилия = jsonObject.getString("фамилия");
            String оценка = jsonObject.getString("оценка");
            String предмет = jsonObject.getString("предмет");

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Студент ").append(фамилия)
                         .append(" получил ").append(оценка)
                         .append(" по предмету ").append(предмет)
                         .append(".");
            System.out.println(stringBuilder.toString());
        }
    }
}
