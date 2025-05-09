import java.util.*;

public class MergeMaps {

    public static void main(String[] args) {
        // Define two maps for merging
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        // Merge the two maps
        Map<String, Integer> mergedMap = mergeMaps(map1, map2);

        // Output the merged map
        System.out.println("Merged Map: " + mergedMap);
    }

    // Method to merge two maps and sum the values for common keys
    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        // Create a new map to store the result
        Map<String, Integer> result = new HashMap<>();

        // First, add all entries from map1 to the result
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            result.put(entry.getKey(), entry.getValue());
        }

        // Now, iterate through map2
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            // If the key already exists in result, sum the values
            result.put(entry.getKey(), result.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }

        return result;
    }
}
