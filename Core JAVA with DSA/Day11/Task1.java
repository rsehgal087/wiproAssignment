package Day11;

class Task1 {

    public static String middleSubstring(String str1, String str2, int length) {
        // Concatenate the strings
        String concatenated = str1.concat(str2);

        // Reverse the concatenated string
        StringBuilder reversed = new StringBuilder(concatenated).reverse();

        // Calculate the middle index
        int middleIndex = reversed.length() / 2;

        // Adjust length if it exceeds the length of the reversed string
        length = Math.min(length, reversed.length());

        // Extract the middle substring
        int startIndex = middleIndex - length / 2;
        int endIndex = startIndex + length;
        String middleSubstring = reversed.substring(startIndex, endIndex);

        return middleSubstring;
    }

    public static void main(String[] args) {
        // Example usage:
        String str1 = "Hello";
        String str2 = "World";
        int length = 5;

        String result = middleSubstring(str1, str2, length);
        System.out.println("Middle substring of length " + length + " is: " + result); // Output: Middle substring of length 5 is: dlroWolleH
    }
}
