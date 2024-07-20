package Day20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Task1 {
    public static void main(String[] args) {
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";

        try {
            Map<String, Integer> wordCount = countWordFrequency(inputFilePath);
            writeWordFrequency(wordCount, outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, Integer> countWordFrequency(String filePath) throws IOException {
        Map<String, Integer> wordCount = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\W+");
            for (String word : words) {
                word = word.toLowerCase();
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        reader.close();
        return wordCount;
    }

    public static void writeWordFrequency(Map<String, Integer> wordCount, String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
        }
        writer.close();
    }
}

