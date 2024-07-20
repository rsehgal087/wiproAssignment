package Day23;

import java.util.Arrays;

interface SortingStrategy {
    void sort(int[] numbers);
}

class BubbleSort implements SortingStrategy {
    @Override
    public void sort(int[] numbers) {
        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }
}

class QuickSort implements SortingStrategy {
    @Override
    public void sort(int[] numbers) {
        quickSort(numbers, 0, numbers.length - 1);
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}

class Context {
    private SortingStrategy strategy;

    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(int[] numbers) {
        strategy.sort(numbers);
    }
}

public class Task4 {
    public static void main(String[] args) {
        Context context = new Context();
        
        int[] numbers = {5, 2, 9, 1, 5, 6};

        context.setStrategy(new BubbleSort());
        context.executeStrategy(numbers);
        System.out.println("Bubble Sort: " + Arrays.toString(numbers));

        numbers = new int[]{5, 2, 9, 1, 5, 6};
        context.setStrategy(new QuickSort());
        context.executeStrategy(numbers);
        System.out.println("Quick Sort: " + Arrays.toString(numbers));
    }
}

