package Day11;

import java.util.*;

class Task5 {

    // Function to find the last occurrence of a substring in a given string using Boyer-Moore algorithm
    public static int boyerMooreLastOccurrence(String text, String pattern) {
        int textLength = text.length();
        int patternLength = pattern.length();

        if (patternLength == 0)
            return 0;

        int[] lastOccurrence = new int[256]; // Assuming ASCII characters

        // Initialize all occurrences as -1
        Arrays.fill(lastOccurrence, -1);

        // Fill the last occurrence of characters in the pattern
        for (int i = 0; i < patternLength; i++) {
            lastOccurrence[(int) pattern.charAt(i)] = i;
        }

        int index = patternLength - 1; // Index in text
        int patternIndex = patternLength - 1; // Index in pattern

        while (index < textLength) {
            int textIndex = index;
            patternIndex = patternLength - 1;

            while (patternIndex >= 0 && text.charAt(textIndex) == pattern.charAt(patternIndex)) {
                textIndex--;
                patternIndex--;
            }

            if (patternIndex == -1) {
                return textIndex + 1; // Found the pattern
            } else {
                int charIndex = (int) text.charAt(index);
                int lastPatternOccurrence = lastOccurrence[charIndex];

                index += patternLength - Math.min(patternIndex, 1 + lastPatternOccurrence);
            }
        }

        return -1; // Pattern not found
    }

    public static void main(String[] args) {
        String text = "ABAAABCD";
        String pattern = "ABC";

        System.out.println("Text: " + text);
        System.out.println("Pattern: " + pattern);
        System.out.println("Last occurrence of pattern at index: " + boyerMooreLastOccurrence(text, pattern));
    }
}

