import java.util.HashMap;
import java.util.Map;

public class HashMapOperations {

    public static void main(String[] args) {
        // Creating a HashMap
        Map<String, Integer> studentGrades = new HashMap<>();

        // Adding elements to the HashMap
        studentGrades.put("Alice", 90);
        studentGrades.put("Bob", 85);
        studentGrades.put("Charlie", 92);
        studentGrades.put("David", 88);

        // Displaying the HashMap
        System.out.println("Initial HashMap: " + studentGrades);

        // Getting the value associated with a key
        String studentName = "Alice";
        int aliceGrade = studentGrades.get(studentName);
        System.out.println(studentName + "'s Grade: " + aliceGrade);

        // Checking if a key is present
        String newStudent = "Eva";
        boolean isNewStudentPresent = studentGrades.containsKey(newStudent);
        System.out.println("Is " + newStudent + " in the HashMap? " + isNewStudentPresent);

        // Updating the value associated with a key
        String existingStudent = "Bob";
        int newGrade = 89;
        studentGrades.put(existingStudent, newGrade);
        System.out.println("Updated HashMap: " + studentGrades);

        // Removing an entry from the HashMap
        String studentToRemove = "Charlie";
        studentGrades.remove(studentToRemove);
        System.out.println("HashMap after removing " + studentToRemove + ": " + studentGrades);

        // Iterating over the entries in the HashMap
        System.out.println("Iterating over HashMap entries:");
        for (Map.Entry<String, Integer> entry : studentGrades.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Checking the size of the HashMap
        int size = studentGrades.size();
        System.out.println("Size of HashMap: " + size);

        // Clearing the HashMap
        studentGrades.clear();
        System.out.println("HashMap after clearing: " + studentGrades);
    }
}
