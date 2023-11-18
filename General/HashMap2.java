class HashNode<K, V> {
    K key;
    V value;

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

class HashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final double LOAD_FACTOR = 0.75;

    private HashNode<K, V>[] table;
    private int size;
    private int capacity;

    public HashMap() {
        this(DEFAULT_CAPACITY);
    }

    public HashMap(int capacity) {
        this.capacity = capacity;
        this.table = new HashNode[capacity];
        this.size = 0;
    }

    private int hash(K key) {
        return key.hashCode() % capacity;
    }

    private int rehash(int hash, int attempt) {
        // Linear probing: linearly search for the next available slot
        return (hash + attempt) % capacity;
    }

    private void resize() {
        int newCapacity = capacity * 2;
        HashNode<K, V>[] newTable = new HashNode[newCapacity];

        for (HashNode<K, V> node : table) {
            if (node != null) {
                int index = hash(node.key);
                int attempt = 0;

                while (newTable[index] != null) {
                    index = rehash(index, ++attempt);
                }

                newTable[index] = node;
            }
        }

        table = newTable;
        capacity = newCapacity;
    }

    public void put(K key, V value) {
        if ((double) size / capacity > LOAD_FACTOR) {
            resize();
        }

        int hash = hash(key);
        int index = hash;
        int attempt = 0;

        while (table[index] != null && !table[index].key.equals(key)) {
            index = rehash(hash, ++attempt);
        }

        if (table[index] == null) {
            table[index] = new HashNode<>(key, value);
            size++;
        } else {
            // Key already exists, update the value
            table[index].value = value;
        }
    }

    public V get(K key) {
        int hash = hash(key);
        int index = hash;
        int attempt = 0;

        while (table[index] != null && !table[index].key.equals(key)) {
            index = rehash(hash, ++attempt);
        }

        return (table[index] != null) ? table[index].value : null;
    }
}

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        // Inserting key-value pairs
        hashMap.put("one", 1);
        hashMap.put("two", 2);
        hashMap.put("three", 3);

        // Retrieving values
        System.out.println("Value for key 'two': " + hashMap.get("two")); // Output: 2
        System.out.println("Value for key 'four': " + hashMap.get("four")); // Output: null
    }
}
