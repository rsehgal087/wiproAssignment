package Day7_Day8;

class Task1 {

    // Node class representing each node in the binary tree
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = right = null;
        }
    }

    // Function to check if the tree is balanced
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    // Helper function to check the height of the tree
    private int checkHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) {
            return -1; // Not balanced
        }

        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) {
            return -1; // Not balanced
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Not balanced
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        Task1 task = new Task1();
        
        // Example usage:
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);

        System.out.println(task.isBalanced(root)); // Output: false (The tree is not balanced)
    }
}

