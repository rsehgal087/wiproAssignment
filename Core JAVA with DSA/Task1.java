package assignments;

public class Task1 {
    private int[] array;
    private int size;

    public Task1() {
        array = new int[2];
        size = 0;
    }

    // Method to insert an element at the end
    public void insert(int element) {
        if (size == array.length) {
            resize();
        }
        array[size++] = element;
    }

    // Method to delete an element at a specific index
    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    // Method to update an element at a specific index
    public void update(int index, int element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        array[index] = element;
    }

    // Method to retrieve an element at a specific index
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return array[index];
    }

    // Method to resize the array when it is full
    private void resize() {
        int newSize = array.length * 2;
        int[] newArray = new int[newSize];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    // Method to get the current size of the array
    public int size() {
        return size;
    }

    // Method to check if the array is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to print the array elements
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Task1 task1 = new Task1();
        task1.insert(1);
        task1.insert(2);
        task1.insert(3);
        task1.print();

        task1.update(1, 4);
        task1.print();

        task1.delete(2);
        task1.print();

        System.out.println("Element at index 1: " + task1.get(1));
        System.out.println("Size of array: " + task1.size());
        System.out.println("Is array empty? " + task1.isEmpty());
    }
}
