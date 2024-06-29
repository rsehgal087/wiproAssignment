package assignments;

public class Task3<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;

    // Inner class to represent a node in the linked list
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Constructor to initialize the queue
    public Task3() {
        front = null;
        rear = null;
        size = 0;
    }

    // Method to add an element to the end of the queue
    public void enqueue(T element) {
        Node<T> newNode = new Node<>(element);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // Method to remove and return the front element of the queue
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return data;
    }

    // Method to return the front element of the queue without removing it
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.data;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Method to return the number of elements in the queue
    public int size() {
        return size;
    }

    // Method to print the elements in the queue
    public void print() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        Node<T> current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Task3<Integer> queue = new Task3<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.print();

        System.out.println("Front element is: " + queue.peek());
        System.out.println("Queue size is: " + queue.size());

        queue.dequeue();
        queue.print();

        System.out.println("Queue is empty: " + queue.isEmpty());
    }
}

