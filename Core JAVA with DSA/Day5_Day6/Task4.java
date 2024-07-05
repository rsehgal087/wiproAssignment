package Day5_Day6;

import java.util.Stack;

class Task4 {
    // Method to sort a stack using an additional temporary stack
    public static Stack<Integer> sortStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();

        while (!stack.isEmpty()) {
            // Pop out the first element
            int temp = stack.pop();

            // While temporary stack is not empty and top
            // of tempStack is greater than temp
            while (!tempStack.isEmpty() && tempStack.peek() > temp) {
                // Pop from temporary stack and push it to the input stack
                stack.push(tempStack.pop());
            }

            // Push temp in temporary stack
            tempStack.push(temp);
        }

        // Return the sorted stack
        return tempStack;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);

        Stack<Integer> sortedStack = sortStack(stack);

        System.out.println("Sorted stack: ");
        while (!sortedStack.isEmpty()) {
            System.out.print(sortedStack.pop() + " ");
        }
    }
}

