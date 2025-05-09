import java.io.*;
import java.util.*;
import java.util.regex.*;

public class WordFrequencyCounter {

    public static void main(String[] args) {
        // Specify the file path (change the path according to your file location)
        String filePath = "sample.txt"; 

        // Call the method to count word frequencies
        Map<String, Integer> wordFrequency = countWordFrequency(filePath);

        // Print the word frequencies
        System.out.println(wordFrequency);
    }

    // Method to count word frequency from the file
    public static Map<String, Integer> countWordFrequency(String filePath) {
        // Create a map to store word frequencies
        Map<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read the file line by line
            while ((line = br.readLine()) != null) {
                // Remove punctuation and split by whitespace using a regular expression
                String[] words = line.toLowerCase().split("\\W+");

                // Iterate through the words and count their frequency
                for (String word : words) {
                    if (!word.isEmpty()) {  // Ignore empty strings
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return wordCountMap;
    }
}
