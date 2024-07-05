package Day5_Day6;

import java.util.Stack;

class Task6 {
    // Method to check if the sequence is present in the stack
    public static boolean isSequencePresent(Stack<Integer> stack, int[] sequence) {
        // Edge case: If sequence is empty, return true
        if (sequence.length == 0) return true;

        // Edge case: If stack is empty and sequence is not empty, return false
        if (stack.isEmpty()) return false;

        // Index to track the position in the sequence
        int sequenceIndex = sequence.length - 1;

        // Iterate through the stack
        while (!stack.isEmpty()) {
            int element = stack.pop();
            // Check if the current element matches the current sequence element
            if (element == sequence[sequenceIndex]) {
                sequenceIndex--;
                // If we've matched the entire sequence, return true
                if (sequenceIndex < 0) {
                    return true;
                }
            } else {
                // If the current element doesn't match and we have started matching the sequence, reset
                sequenceIndex = sequence.length - 1;
            }
        }

        // If we exit the loop without matching the entire sequence, return false
        return false;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        int[] sequence = {3, 4, 5};

        boolean result = isSequencePresent(stack, sequence);
        System.out.println("Is the sequence present in the stack? " + result);
    }
}

