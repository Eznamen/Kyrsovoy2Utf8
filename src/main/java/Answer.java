import com.google.gson.Gson;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Answer {

    public static Map<String, String> Categ(File txtFile) throws IOException {
        Map<String, String> categories = new HashMap<>();
        try (Scanner scanner = new Scanner(txtFile)) {
            while (scanner.hasNext()) {
                String[] parts = scanner.nextLine().split("\\P{IsAlphabetic}+");
                String key = parts[0];
                String value = parts[1];
                categories.put(key, value);
            }
        }
        return categories;
    }

    public static Map<String, Integer> Answ(ArrayList<Pokupki> pokupki, Map<String, String> map) throws NullPointerException {
        Map<String, Integer> map1 = new HashMap<>();
        String category;

        for (Pokupki pokupka : pokupki) {
            category = map.containsKey(pokupka.getTitle()) ? map.get(pokupka.getTitle()) : "другое";
            Integer allSum;

            if (map1.get(category) == null) {
                allSum = pokupka.getSum();
                map1.put(category, allSum);
            } else {
                allSum = map.containsKey(pokupka.getTitle()) ? map1.get(category) : 0;

                allSum += pokupka.getSum();
                map1.put(category, allSum);
            }
        }
        return map1;
    }
}