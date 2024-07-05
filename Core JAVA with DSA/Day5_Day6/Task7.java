package Day5_Day6;

class Task7 {
    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    // Method to merge two sorted linked lists without using extra space
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Create a dummy node to form the new sorted list
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Traverse both lists and link the nodes in sorted order
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        // Link the remaining nodes, if any
        if (l1 != null) {
            tail.next = l1;
        } else {
            tail.next = l2;
        }

        // Return the head of the merged list
        return dummy.next;
    }

    public static void main(String[] args) {
        Task7 task = new Task7();

        // Create first sorted linked list
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        // Create second sorted linked list
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        // Merge the two sorted linked lists
        ListNode mergedHead = task.mergeTwoLists(l1, l2);

        // Print the merged linked list
        System.out.print("Merged sorted linked list: ");
        while (mergedHead != null) {
            System.out.print(mergedHead.val + " ");
            mergedHead = mergedHead.next;
        }
    }
}

