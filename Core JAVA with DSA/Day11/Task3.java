package Day11;

class Task3 {

    // Compute temporary array to maintain size of suffix which is same as prefix
    private static int[] computeLPSArray(String pattern) {
        int patternLength = pattern.length();
        int[] lps = new int[patternLength];
        int len = 0;
        int i = 1;
        
        while (i < patternLength) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }
        return lps;
    }

    // KMP pattern searching algorithm
    public static void KMPSearch(String text, String pattern) {
        int textLength = text.length();
        int patternLength = pattern.length();
        int[] lps = computeLPSArray(pattern);
        int i = 0; // index for text[]
        int j = 0; // index for pattern[]
        int comparisons = 0;

        while (i < textLength) {
            comparisons++;
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }
            if (j == patternLength) {
                System.out.println("Pattern found at index " + (i - j));
                j = lps[j - 1];
            } else if (i < textLength && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }

        System.out.println("Total comparisons made: " + comparisons);
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";

        System.out.println("Text: " + text);
        System.out.println("Pattern: " + pattern);
        System.out.println("KMP Pattern Search:");
        KMPSearch(text, pattern);
    }
}

