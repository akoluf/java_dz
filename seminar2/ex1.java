/**
 Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса,
используя StringBuilder. Данные для фильтрации приведены ниже в виде json строки.
Если значение null, то параметр не должен попадать в запрос.
Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 */

package seminar2;
import org.json.JSONObject;

public class ex1 {
    public static void main(String[] args) {
        String baseQuery = "выберите * среди студентов, где ";
        String jsonString = "{\"name\": \"Ivanov\", \"country\": \"Russia\", \"city\": \"Moscow\", \"age\": \"null\"}";

        String query = formQuery(baseQuery, jsonString);
        System.out.println(query);
    }

    // Функция для формирования запроса
    public static String formQuery(String baseQuery, String jsonString) {
        JSONObject jsonObject = new JSONObject(jsonString);
        StringBuilder whereClause = new StringBuilder();

        for (String key : jsonObject.keySet()) {
            Object value = jsonObject.get(key);
            if (value != JSONObject.NULL) {
                if (whereClause.length() != 0) {
                    whereClause.append(" AND ");
                }
                whereClause.append(key).append(" = '").append(value).append("'");
            }
        }

        return baseQuery + whereClause.toString();
    }
}
