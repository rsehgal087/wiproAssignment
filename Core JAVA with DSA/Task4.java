package assignments;

public class Task4<T> {
    private Node<T> head;
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

    // Constructor to initialize the linked list
    public Task4() {
        head = null;
        size = 0;
    }

    // Method to add an element at the end of the list
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Method to remove an element at a specified index
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    // Method to retrieve an element at a specified index
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    // Method to display all elements in the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to get the current size of the list
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Task4<Integer> list = new Task4<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.display();

        System.out.println("Element at index 1: " + list.get(1));
        System.out.println("List size: " + list.size());

        list.remove(1);
        list.display();

        System.out.println("List size: " + list.size());
    }
}

