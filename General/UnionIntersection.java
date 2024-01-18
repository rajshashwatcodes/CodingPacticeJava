import java.util.HashSet;
import java.util.Set;

public class UnionIntersection {

    public static <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);
        return unionSet;
    }

    public static <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        Set<T> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2);
        return intersectionSet;
    }

    public static void main(String[] args) {
        // Creating two sets
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // Adding elements to the sets
        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(2);
        set2.add(3);
        set2.add(4);

        // Finding the union of the sets
        Set<Integer> unionResult = union(set1, set2);
        System.out.println("Union of set1 and set2: " + unionResult);

        // Finding the intersection of the sets
        Set<Integer> intersectionResult = intersection(set1, set2);
        System.out.println("Intersection of set1 and set2: " + intersectionResult);
    }
}
