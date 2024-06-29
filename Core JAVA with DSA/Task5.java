package assignments;

public class Task5 {
    // Method to perform linear search on an array of integers
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Return index if target is found
            }
        }
        return -1; // Return -1 if target is not found
    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 7, 9, 1, 4 };
        int target = 3;

        int index = linearSearch(arr, target);

        if (index != -1) {
            System.out.println("Target " + target + " found at index " + index);
        } else {
            System.out.println("Target " + target + " not found in the array");
        }
    }
}

