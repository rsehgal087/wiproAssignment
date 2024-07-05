package Day5_Day6;

class Task5 {
    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    // Method to remove all duplicates from a sorted linked list
    public ListNode removeAllDuplicates(ListNode head) {
        // Create a dummy node to handle edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode current = head;

        while (current != null) {
            // Move the current pointer to the end of the duplicates
            while (current.next != null && current.val == current.next.val) {
                current = current.next;
            }

            // Check if prev.next is current
            if (prev.next == current) {
                // No duplicates detected, move prev pointer
                prev = prev.next;
            } else {
                // Duplicates detected, skip all duplicates
                prev.next = current.next;
            }

            // Move current pointer
            current = current.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Example usage
        Task5 task = new Task5();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next = new ListNode(5);

        ListNode newHead = task.removeAllDuplicates(head);
        System.out.print("Linked list after removing all duplicates: ");
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }
}

