package Day19;

public class Task2 {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"A", "B", "C", "D"};

        System.out.println("Before Swap:");
        printArray(intArray);
        printArray(strArray);

        swap(intArray, 1, 3);
        swap(strArray, 0, 2);

        System.out.println("After Swap:");
        printArray(intArray);
        printArray(strArray);
    }

    public static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

