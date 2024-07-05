package Day5_Day6;

class Task8 {
    // Method to perform binary search on a rotated sorted array
    public int searchInRotatedSortedArray(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Check if the mid element is the target
            if (arr[mid] == target) {
                return mid;
            }

            // Determine which part is sorted
            if (arr[start] <= arr[mid]) { // Left part is sorted
                // Check if the target is within the sorted left part
                if (arr[start] <= target && target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else { // Right part is sorted
                // Check if the target is within the sorted right part
                if (arr[mid] < target && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        // Target not found
        return -1;
    }

    public static void main(String[] args) {
        Task8 task = new Task8();
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int result = task.searchInRotatedSortedArray(arr, target);
        System.out.println("Index of target element: " + result); // Output: 4
    }
}

