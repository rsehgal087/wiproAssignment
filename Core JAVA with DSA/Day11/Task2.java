package Day11;

class Task2 {

    // Naive pattern searching algorithm
    public static void naivePatternSearch(String text, String pattern) {
        int textLength = text.length();
        int patternLength = pattern.length();
        int comparisons = 0;

        for (int i = 0; i <= textLength - patternLength; i++) {
            int j;

            // Check for pattern match starting at index i
            for (j = 0; j < patternLength; j++) {
                comparisons++;
                if (text.charAt(i + j) != pattern.charAt(j))
                    break;
            }

            if (j == patternLength) {
                System.out.println("Pattern found at index " + i);
            }
        }

        System.out.println("Total comparisons made: " + comparisons);
    }

    public static void main(String[] args) {
        String text = "AABAACAADAABAAABAA";
        String pattern = "AABA";
        
        System.out.println("Text: " + text);
        System.out.println("Pattern: " + pattern);
        System.out.println("Naive Pattern Search:");
        naivePatternSearch(text, pattern);
    }
}

