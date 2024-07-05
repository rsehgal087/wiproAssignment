package Day5_Day6;

class Task2 {
    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    // Method to find the middle element of the linked list
    public ListNode findMiddleElement(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        // Move fast pointer two steps and slow pointer one step at a time
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Slow pointer will be at the middle element
        return slow;
    }

    public static void main(String[] args) {
        // Example usage
        Task2 task = new Task2();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode middle = task.findMiddleElement(head);
        System.out.println("Middle element is: " + (middle != null ? middle.val : "null"));
    }
}
