package Day7_Day8;

import java.util.ArrayList;

class Task3 {

    static class MinHeap {
        private ArrayList<Integer> heap;

        public MinHeap() {
            heap = new ArrayList<>();
        }

        // Method to get the index of the parent node
        private int parent(int index) {
            return (index - 1) / 2;
        }

        // Method to get the index of the left child node
        private int leftChild(int index) {
            return 2 * index + 1;
        }

        // Method to get the index of the right child node
        private int rightChild(int index) {
            return 2 * index + 2;
        }

        // Method to insert an element into the heap
        public void insert(int element) {
            heap.add(element);
            int index = heap.size() - 1;
            heapifyUp(index);
        }

        // Method to maintain the heap property after insertion
        private void heapifyUp(int index) {
            while (index != 0 && heap.get(parent(index)) > heap.get(index)) {
                swap(index, parent(index));
                index = parent(index);
            }
        }

        // Method to fetch the minimum element
        public int getMin() {
            if (heap.isEmpty()) {
                throw new IllegalStateException("Heap is empty");
            }
            return heap.get(0);
        }

        // Method to delete the minimum element
        public void deleteMin() {
            if (heap.isEmpty()) {
                throw new IllegalStateException("Heap is empty");
            }
            int lastIndex = heap.size() - 1;
            heap.set(0, heap.get(lastIndex));
            heap.remove(lastIndex);
            heapifyDown(0);
        }

        // Method to maintain the heap property after deletion
        private void heapifyDown(int index) {
            int smallest = index;
            int left = leftChild(index);
            int right = rightChild(index);

            if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
                smallest = left;
            }

            if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
                smallest = right;
            }

            if (smallest != index) {
                swap(index, smallest);
                heapifyDown(smallest);
            }
        }

        // Method to swap two elements in the heap
        private void swap(int i, int j) {
            int temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();

        // Example usage:
        minHeap.insert(3);
        minHeap.insert(1);
        minHeap.insert(6);
        minHeap.insert(5);
        minHeap.insert(2);
        minHeap.insert(4);

        System.out.println(minHeap.getMin()); // Output: 1

        minHeap.deleteMin();
        System.out.println(minHeap.getMin()); // Output: 2

        minHeap.deleteMin();
        System.out.println(minHeap.getMin()); // Output: 3
    }
}

