import java.util.ArrayList;
import java.util.List;

public class MountainRanges {
    public static List<Integer> findMountainRanges(int[] arr) {
        List<Integer> ranges = new ArrayList<>();
        int n = arr.length;
        
        // Edge case: If the array length is less than 3, return an empty list
        if (n < 3) {
            return ranges;
        }
        
        int start = 0;
        int end = 0;
        boolean inRange = false;
        
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                if (!inRange) {
                    start = i - 1;
                    inRange = true;
                }
            } else if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                if (inRange) {
                    end = i;
                    ranges.add(start);
                    ranges.add(end);
                    inRange = false;
                }
            }
        }
        
        // Check if a mountain range is still in progress at the end of the array
        if (inRange) {
            ranges.add(start);
            ranges.add(n - 1);
        }
        
        return ranges;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 4, 2, 6, 7, 9};
        List<Integer> ranges = findMountainRanges(arr);
        System.out.println("Mountain ranges found:");
        for (int i = 0; i < ranges.size(); i += 2) {
            int start = ranges.get(i);
            int end = ranges.get(i + 1);
            System.out.println("Range from index " + start + " to index " + end);
        }
    }
}
