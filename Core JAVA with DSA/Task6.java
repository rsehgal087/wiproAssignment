package assignments;

public class Task6 {

    public static int binarySearch(int[] sortedArray, int target) {
        int left = 0;
        int right = sortedArray.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (sortedArray[mid] == target) {
                return mid; // Target found
            }
            if (sortedArray[mid] < target) {
                left = mid + 1; // Ignore left half
            } else {
                right = mid - 1; // Ignore right half
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 7;
        int result = binarySearch(sortedArray, target);

        if (result != -1) {
            System.out.println("Target found at index: " + result);
        } else {
            System.out.println("Target not found");
        }
    }
}

