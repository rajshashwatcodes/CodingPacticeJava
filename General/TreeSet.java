import java.util.TreeSet;

public class TreeSet {

    public static void main(String[] args) {
        // Creating a TreeSet
        TreeSet<Integer> numbersSet = new TreeSet<>();

        // Adding elements to the TreeSet
        numbersSet.add(5);
        numbersSet.add(2);
        numbersSet.add(8);
        numbersSet.add(1);
        numbersSet.add(3);

        // Displaying the TreeSet
        System.out.println("TreeSet: " + numbersSet);

        // Checking if an element is present
        int searchElement = 3;
        boolean isPresent = numbersSet.contains(searchElement);
        System.out.println("Is " + searchElement + " present? " + isPresent);

        // Removing an element
        int removeElement = 2;
        numbersSet.remove(removeElement);
        System.out.println("TreeSet after removing " + removeElement + ": " + numbersSet);

        // Iterating over the TreeSet
        System.out.println("Iterating over TreeSet elements:");
        for (Integer number : numbersSet) {
            System.out.println(number);
        }

        // Checking the size of the TreeSet
        int size = numbersSet.size();
        System.out.println("Size of TreeSet: " + size);

        // Clearing the TreeSet
        numbersSet.clear();
        System.out.println("TreeSet after clearing: " + numbersSet);
    }
}
