class TrieNode {
    char value;
    boolean isEndOfWord;
    TrieNode[] children;

    public TrieNode(char value) {
        this.value = value;
        this.isEndOfWord = false;
        this.children = new TrieNode[26]; // Assuming only lowercase English letters
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode('\0'); // Root node has a null character value
    }

    public void insert(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode(ch);
            }

            current = current.children[index];
        }

        // Mark the end of the word
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = searchNode(word);
        return node != null && node.isEndOfWord;
    }

    private TrieNode searchNode(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (current.children[index] == null) {
                return null; // The word is not in the trie
            }

            current = current.children[index];
        }

        return current;
    }
}

public class TrieInsert {
    public static void main(String[] args) {
        Trie trie = new Trie();

        // Inserting words into the trie
        trie.insert("apple");
        trie.insert("app");
        trie.insert("banana");

        // Searching for words in the trie
        System.out.println(trie.search("apple"));    // Output: true
        System.out.println(trie.search("apples"));   // Output: false
        System.out.println(trie.search("app"));      // Output: true
        System.out.println(trie.search("banana"));   // Output: true
        System.out.println(trie.search("ban"));      // Output: false
    }
}
