package assignments;

public class Task9 {

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);

            quickSort(array, low, pi - 1); // Recursively sort the left subarray
            quickSort(array, pi + 1, high); // Recursively sort the right subarray
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high]; // Choose the rightmost element as pivot
        int i = (low - 1); // Index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (array[j] <= pivot) {
                i++;

                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap array[i + 1] and array[high] (or pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] array = {10, 7, 8, 9, 1, 5};
        System.out.println("Unsorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        quickSort(array, 0, array.length - 1);

        System.out.println("\nSorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}

