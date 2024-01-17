import java.util.HashSet;
import java.util.Iterator;

public class HashSetIteration {

    public static void main(String[] args) {
        // Creating a HashSet
        HashSet<String> fruitsSet = new HashSet<>();

        // Adding elements to the HashSet
        fruitsSet.add("Apple");
        fruitsSet.add("Banana");
        fruitsSet.add("Orange");
        fruitsSet.add("Mango");

        // Using Iterator to iterate over HashSet elements
        System.out.println("Iterating over HashSet using Iterator:");
        Iterator<String> iterator = fruitsSet.iterator();
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.println(fruit);
        }

        // Using enhanced for loop to iterate over HashSet elements
        System.out.println("\nIterating over HashSet using enhanced for loop:");
        for (String fruit : fruitsSet) {
            System.out.println(fruit);
        }
    }
}
