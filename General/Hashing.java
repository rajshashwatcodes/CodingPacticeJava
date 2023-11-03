import java.util.Arrays;

class HashTable {
    private String[] array;
    private int size;

    public HashTable(int size) {
        this.size = size;
        array = new String[size];
        Arrays.fill(array, null);
    }

    // A simple hash function (for demonstration purposes)
    private int hash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash + key.charAt(i)) % size;
        }
        return hash;
    }

    // Insert a key-value pair into the hash table
    public void put(String key, String value) {
        int index = hash(key);
        array[index] = value;
    }

    // Retrieve the value associated with a key from the hash table
    public String get(String key) {
        int index = hash(key);
        return array[index];
    }

    public void displayTable() {
        System.out.println("Hash Table:");
        for (int i = 0; i < size; i++) {
            System.out.println("Index " + i + ": " + array[i]);
        }
    }
}

public class HashingExample {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);

        hashTable.put("apple", "A fruit");
        hashTable.put("banana", "Another fruit");
        hashTable.put("car", "A vehicle");

        hashTable.displayTable();

        System.out.println("Value for 'apple': " + hashTable.get("apple"));
        System.out.println("Value for 'banana': " + hashTable.get("banana"));
    }
}
