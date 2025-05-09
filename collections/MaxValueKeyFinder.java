import java.util.*;

public class MaxValueKeyFinder {

    public static void main(String[] args) {
        // Input map
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);

        // Find the key with the highest value
        String keyWithMaxValue = findKeyWithMaxValue(map);

        // Output the key
        System.out.println("Key with highest value: " + keyWithMaxValue);
    }

    // Method to find the key with the maximum value in the map
    public static String findKeyWithMaxValue(Map<String, Integer> map) {
        // Initialize variables to store the key and value of the highest entry
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        // Iterate through each entry in the map
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        return maxKey;
    }
}
