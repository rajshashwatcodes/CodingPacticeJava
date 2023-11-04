import java.util.LinkedList;

class KeyValuePair<K, V> {
    K key;
    V value;

    public KeyValuePair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

public class HashMap<K, V> {
    private LinkedList<KeyValuePair<K, V>>[] array;
    private int capacity;

    @SuppressWarnings("unchecked")
    public HashMap(int capacity) {
        this.capacity = capacity;
        array = (LinkedList<KeyValuePair<K, V>>[]) new LinkedList[capacity];

        for (int i = 0; i < capacity; i++) {
            array[i] = new LinkedList<>();
        }
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        for (KeyValuePair<K, V> pair : array[index]) {
            if (pair.key.equals(key)) {
                pair.value = value; // Update value if key already exists
                return;
            }
        }
        array[index].add(new KeyValuePair<>(key, value));
    }

    public V get(K key) {
        int index = getIndex(key);
        for (KeyValuePair<K, V> pair : array[index]) {
            if (pair.key.equals(key)) {
                return pair.value;
            }
        }
        return null; // Key not found
    }

    private int getIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % capacity;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>(10);

        hashMap.put("one", 1);
        hashMap.put("two", 2);
        hashMap.put("three", 3);

        System.out.println("Value for 'two': " + hashMap.get("two")); // Output: 2
        System.out.println("Value for 'four': " + hashMap.get("four")); // Output: null
    }
}
