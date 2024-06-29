package assignments;

public class Task2 {
    private int[] stack;
    private int top;
    private int capacity;

    // Constructor to initialize the stack with a specified capacity
    public Task2(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
        top = -1;
    }

    // Method to add an element to the top of the stack
    public void push(int element) {
        if (top == capacity - 1) {
            throw new StackOverflowError("Stack is full");
        }
        stack[++top] = element;
    }

    // Method to remove and return the top element of the stack
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top--];
    }

    // Method to return the top element of the stack without removing it
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top];
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Method to return the number of elements in the stack
    public int size() {
        return top + 1;
    }

    // Method to print the elements in the stack
    public void print() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Task2 stack = new Task2(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.print();

        System.out.println("Top element is: " + stack.peek());
        System.out.println("Stack size is: " + stack.size());

        stack.pop();
        stack.print();

        System.out.println("Stack is empty: " + stack.isEmpty());
    }
}
