import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
        }
        current.isEndOfWord = true;
    }

    public String findLongestPrefix() {
        StringBuilder longestPrefix = new StringBuilder();
        TrieNode current = root;

        while (current.children.size() == 1 && !current.isEndOfWord) {
            char ch = current.children.keySet().iterator().next();
            longestPrefix.append(ch);
            current = current.children.get(ch);
        }

        return longestPrefix.toString();
    }
}

public class LongestPrefixWord {
    public static String longestPrefix(String[] words) {
        Trie trie = new Trie();

        // Insert all words into the trie
        for (String word : words) {
            trie.insert(word);
        }

        // Find the longest common prefix
        return trie.findLongestPrefix();
    }

    public static void main(String[] args) {
        String[] words = {"apple", "app", "apricot", "apex"};

        String longestPrefix = longestPrefix(words);

        if (longestPrefix.isEmpty()) {
            System.out.println("No common prefix found.");
        } else {
            System.out.println("Longest common prefix: " + longestPrefix);
        }
    }
}
