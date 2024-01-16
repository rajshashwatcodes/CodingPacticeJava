import java.util.HashSet;

public class HashSet {

    public static void main(String[] args) {
        // Creating a HashSet
        HashSet<String> countriesSet = new HashSet<>();

        // Adding elements to the HashSet
        countriesSet.add("India");
        countriesSet.add("USA");
        countriesSet.add("China");
        countriesSet.add("Brazil");
        countriesSet.add("India"); // Adding a duplicate element

        // Displaying the HashSet
        System.out.println("HashSet: " + countriesSet);

        // Checking if an element is present
        String searchCountry = "USA";
        boolean isPresent = countriesSet.contains(searchCountry);
        System.out.println("Is " + searchCountry + " present? " + isPresent);

        // Removing an element
        String removeCountry = "China";
        countriesSet.remove(removeCountry);
        System.out.println("HashSet after removing " + removeCountry + ": " + countriesSet);

        // Iterating over the HashSet
        System.out.println("Iterating over HashSet elements:");
        for (String country : countriesSet) {
            System.out.println(country);
        }

        // Checking the size of the HashSet
        int size = countriesSet.size();
        System.out.println("Size of HashSet: " + size);

        // Clearing the HashSet
        countriesSet.clear();
        System.out.println("HashSet after clearing: " + countriesSet);
    }
}
