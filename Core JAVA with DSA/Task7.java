package assignments;

public class Task7 {

    public static int jumpSearch(int[] sortedArray, int target) {
        int n = sortedArray.length;
        int step = (int) Math.floor(Math.sqrt(n));
        int prev = 0;

        while (sortedArray[Math.min(step, n) - 1] < target) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            if (prev >= n) {
                return -1; // Target not found
            }
        }

        while (sortedArray[prev] < target) {
            prev++;
            if (prev == Math.min(step, n)) {
                return -1; // Target not found
            }
        }

        if (sortedArray[prev] == target) {
            return prev; // Target found
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 7;
        int result = jumpSearch(sortedArray, target);

        if (result != -1) {
            System.out.println("Target found at index: " + result);
        } else {
            System.out.println("Target not found");
        }
    }
}

