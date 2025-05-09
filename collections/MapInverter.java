import java.util.*;

public class MapInverter {

    public static void main(String[] args) {
        // Input map
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("A", 1);
        originalMap.put("B", 2);
        originalMap.put("C", 1);

        // Invert the map
        Map<Integer, List<String>> invertedMap = invertMap(originalMap);

        // Display the inverted map
        System.out.println(invertedMap);
    }

    // Method to invert the map
    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> originalMap) {
        // New map to store the inverted result
        Map<V, List<K>> invertedMap = new HashMap<>();

        // Iterate through the original map
        for (Map.Entry<K, V> entry : originalMap.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();

            // If the value is already a key in the inverted map, add the key to the list
            invertedMap.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }

        return invertedMap;
    }
}
