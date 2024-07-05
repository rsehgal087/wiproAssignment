package Day11;

import java.util.*;

class Task4 {

    // Function to perform Rabin-Karp substring search
    public static void rabinKarpSearch(String text, String pattern) {
        int textLength = text.length();
        int patternLength = pattern.length();

        // Prime number to be used for hash calculation (can be any prime)
        final int prime = 101;

        // Calculate prime^(patternLength-1) % largePrime for rolling hash
        long primePower = 1;
        for (int i = 0; i < patternLength - 1; i++) {
            primePower = (primePower * prime) % Integer.MAX_VALUE;
        }

        // Calculate initial hash values for text and pattern
        long patternHash = calculateHash(pattern, patternLength, prime);
        long textHash = calculateHash(text, patternLength, prime);

        // Iterate through the text with rolling hash and compare hashes
        for (int i = 0; i <= textLength - patternLength; i++) {
            // Check if the hashes match
            if (patternHash == textHash && checkEqual(text, pattern, i, patternLength)) {
                System.out.println("Pattern found at index " + i);
            }

            // Calculate hash for the next substring in text
            if (i < textLength - patternLength) {
                textHash = recalculateHash(text, textHash, i, patternLength, prime, primePower);
            }
        }
    }

    // Function to calculate hash value for a substring
    private static long calculateHash(String str, int length, int prime) {
        long hash = 0;
        for (int i = 0; i < length; i++) {
            hash = (hash * prime + str.charAt(i)) % Integer.MAX_VALUE;
        }
        return hash;
    }

    // Function to recalculate hash value for the next substring using rolling hash
    private static long recalculateHash(String str, long oldHash, int oldIndex, int patternLength, int prime, long primePower) {
        long newHash = oldHash - str.charAt(oldIndex);
        newHash = newHash / prime;
        newHash += str.charAt(oldIndex + patternLength) * primePower;
        return newHash % Integer.MAX_VALUE;
    }

    // Function to check if two substrings are equal
    private static boolean checkEqual(String text, String pattern, int startIndex, int patternLength) {
        for (int i = 0; i < patternLength; i++) {
            if (text.charAt(startIndex + i) != pattern.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String text = "ABCCDDAEFG";
        String pattern = "CDD";

        System.out.println("Text: " + text);
        System.out.println("Pattern: " + pattern);
        System.out.println("Rabin-Karp Pattern Search:");
        rabinKarpSearch(text, pattern);
    }
}

