import java.util.*;

public class FrequencyCounter {

    public static Map<String, Integer> countFrequencies(List<String> items) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String item : items) {
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }

        return frequencyMap;
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("apple", "banana", "apple", "orange");

        Map<String, Integer> result = countFrequencies(input);

        System.out.println("Frequency Map: " + result);
    }
}
