package book_c9.map.hasmap;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        // Creating a HashMap (which implements the Map interface)
        Map<String, Integer> studentScores = new HashMap<>();

        // Adding key-value pairs to the map
        studentScores.put("Alice", 95);
        studentScores.put("Bob", 87);
        studentScores.put("Charlie", 78);

        // Accessing values using keys
        System.out.println("Bob's score: " + studentScores.get("Bob"));

        // Iterating over the map entries
        System.out.println("Student scores:");
        for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Feactures
        // exact time returning any element
        // values can no repeat
        // key ethier

        // Checking if a key exists in the map
        String searchKey = "Alice";
        if (studentScores.containsKey(searchKey)) {
            System.out.println(searchKey + "'s score is present in the map.");
        } else {
            System.out.println(searchKey + "'s score is not present in the map.");
        }
    }
}
