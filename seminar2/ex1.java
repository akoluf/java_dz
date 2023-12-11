
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
