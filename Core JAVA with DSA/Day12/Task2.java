package Day12;

class Task2 {
    // Method to find the two non-repeating elements in an array
    public void findNonRepeatingElements(int[] nums) {
        // Step 1: Compute xorAll as XOR of all elements
        int xorAll = 0;
        for (int num : nums) {
            xorAll ^= num;
        }

        // Step 2: Find the rightmost set bit
        int rightmostSetBit = xorAll & -xorAll;

        // Step 3: Partition the array into two groups based on the rightmost set bit
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & rightmostSetBit) != 0) {
                a ^= num; // XOR elements where rightmostSetBit is set
            } else {
                b ^= num; // XOR elements where rightmostSetBit is not set
            }
        }

        // Print the two non-repeating elements
        System.out.println("Non-repeating elements: " + a + " and " + b);
    }

    public static void main(String[] args) {
        Task2 task = new Task2();
        int[] nums = {1, 2, 3, 4, 4, 5, 5, 6};
        task.findNonRepeatingElements(nums); // Output: Non-repeating elements: 1 and 2
    }
}

