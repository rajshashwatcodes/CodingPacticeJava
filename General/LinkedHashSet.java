import java.util.LinkedHashSet;
import java.util.Iterator;

public class LinkedHashSet {
    public static void main(String[] args) {
        // Create a LinkedHashSet
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        // Add elements to the LinkedHashSet
        linkedHashSet.add("Apple");
        linkedHashSet.add("Banana");
        linkedHashSet.add("Orange");
        linkedHashSet.add("Apple"); // Duplicate elements are not allowed

        // Print the elements of the LinkedHashSet
        System.out.println("LinkedHashSet elements: " + linkedHashSet);

        // Iterate over the elements using an Iterator
        System.out.println("Iterating over LinkedHashSet elements:");
        Iterator<String> iterator = linkedHashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Check if a specific element is present
        String searchElement = "Banana";
        if (linkedHashSet.contains(searchElement)) {
            System.out.println(searchElement + " is present in the LinkedHashSet.");
        } else {
            System.out.println(searchElement + " is not present in the LinkedHashSet.");
        }

        // Remove an element
        linkedHashSet.remove("Orange");
        System.out.println("After removing 'Orange', LinkedHashSet elements: " + linkedHashSet);

        // Check if the LinkedHashSet is empty
        System.out.println("Is LinkedHashSet empty? " + linkedHashSet.isEmpty());

        // Get the size of the LinkedHashSet
        System.out.println("Size of LinkedHashSet: " + linkedHashSet.size());

        // Clear all elements from the LinkedHashSet
        linkedHashSet.clear();
        System.out.println("After clearing, LinkedHashSet elements: " + linkedHashSet);
    }
}
