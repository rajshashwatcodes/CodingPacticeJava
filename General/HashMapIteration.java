import java.util.HashMap;
import java.util.Map;

public class HashMapIteration {

    public static void main(String[] args) {
        // Creating a HashMap
        Map<String, Integer> studentGrades = new HashMap<>();

        // Adding elements to the HashMap
        studentGrades.put("Alice", 90);
        studentGrades.put("Bob", 85);
        studentGrades.put("Charlie", 92);
        studentGrades.put("David", 88);

        // Iterating over entries using entrySet()
        System.out.println("Iterating over entries using entrySet():");
        for (Map.Entry<String, Integer> entry : studentGrades.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Iterating over keys using keySet()
        System.out.println("\nIterating over keys using keySet():");
        for (String studentName : studentGrades.keySet()) {
            System.out.println("Student: " + studentName);
        }

        // Iterating over values using values()
        System.out.println("\nIterating over values using values():");
        for (int grade : studentGrades.values()) {
            System.out.println("Grade: " + grade);
        }
    }
}
