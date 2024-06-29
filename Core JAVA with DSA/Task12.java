package assignments;

public class Task12 {

    // Node class representing each node in the binary tree
    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    // Root of the Binary Tree
    Node root;

    // Constructor for Task12
    Task12() {
        root = null;
    }

    // Method to insert a new key in the binary tree
    void insert(int key) {
        root = insertRec(root, key);
    }

    // Recursive function to insert a new key in the binary tree
    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    // Method to delete a key from the binary tree
    void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    // Recursive function to delete a key from the binary tree
    Node deleteRec(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    // Method to find the minimum value node
    int minValue(Node root) {
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

    // Method for inorder traversal
    void inorder() {
        inorderRec(root);
    }

    // Recursive function for inorder traversal
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Method for preorder traversal
    void preorder() {
        preorderRec(root);
    }

    // Recursive function for preorder traversal
    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Method for postorder traversal
    void postorder() {
        postorderRec(root);
    }

    // Recursive function for postorder traversal
    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key + " ");
        }
    }

    // Main method to test the above methods
    public static void main(String[] args) {
        Task12 tree = new Task12();

        // Insert nodes
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Print inorder traversal of the tree
        System.out.println("Inorder traversal:");
        tree.inorder();
        System.out.println();

        // Print preorder traversal of the tree
        System.out.println("Preorder traversal:");
        tree.preorder();
        System.out.println();

        // Print postorder traversal of the tree
        System.out.println("Postorder traversal:");
        tree.postorder();
        System.out.println();

        // Delete a node
        System.out.println("Delete 20");
        tree.deleteKey(20);
        System.out.println("Inorder traversal after deletion:");
        tree.inorder();
        System.out.println();

        // Delete another node
        System.out.println("Delete 30");
        tree.deleteKey(30);
        System.out.println("Inorder traversal after deletion:");
        tree.inorder();
        System.out.println();

        // Delete another node
        System.out.println("Delete 50");
        tree.deleteKey(50);
        System.out.println("Inorder traversal after deletion:");
        tree.inorder();
        System.out.println();
    }
}

