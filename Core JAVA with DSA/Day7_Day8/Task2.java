package Day7_Day8;

class Task2 {
    
    // Trie node class
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    // Trie class
    static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Method to insert a word into the Trie
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isEndOfWord = true;
        }

        // Method to check if there is any word in the Trie that starts with the given prefix
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                int index = prefix.charAt(i) - 'a';
                if (node.children[index] == null) {
                    return false;
                }
                node = node.children[index];
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        
        // Example usage:
        trie.insert("apple");
        trie.insert("app");
        trie.insert("apricot");

        System.out.println(trie.startsWith("app")); // Output: true
        System.out.println(trie.startsWith("apr")); // Output: true
        System.out.println(trie.startsWith("ape")); // Output: false
    }
}
