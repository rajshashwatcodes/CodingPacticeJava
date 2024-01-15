import java.util.Arrays;

public class ValidAnagram {

    public static boolean areAnagrams(String str1, String str2) {
        // Check if the lengths of the strings are different
        if (str1.length() != str2.length()) {
            return false;
        }

        // Convert strings to char arrays and sort them
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        // Compare the sorted char arrays
        return Arrays.equals(charArray1, charArray2);
    }

    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";

        if (areAnagrams(str1, str2)) {
            System.out.println(str1 + " and " + str2 + " are valid anagrams.");
        } else {
            System.out.println(str1 + " and " + str2 + " are not valid anagrams.");
        }
    }
}
