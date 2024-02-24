
import java.util.Map;
import java.util.Map.Entry;

public class MapFactory {
    public static void main(String[] args) {
        // Creating a Map using Map.ofEntries factory method
        Map<Integer, String> map = Map.ofEntries(
                Map.entry(1, "One"),
                Map.entry(2, "Two"),
                Map.entry(3, "Three"));

        // Displaying the elements of the map
        for (Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // Error beacuse is immutuable
        // map.clear();
    }
}