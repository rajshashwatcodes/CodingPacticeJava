import java.util.Stack;

public class StringDecoder {
    public static String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder currentStr = new StringBuilder();
        int currentNum = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                currentNum = currentNum * 10 + (c - '0');
            } else if (c == '[') {
                numStack.push(currentNum);
                strStack.push(currentStr);
                currentNum = 0;
                currentStr = new StringBuilder();
            } else if (c == ']') {
                int num = numStack.pop();
                StringBuilder prevStr = strStack.pop();
                for (int i = 0; i < num; i++) {
                    prevStr.append(currentStr);
                }
                currentStr = prevStr;
            } else {
                currentStr.append(c);
            }
        }

        return currentStr.toString();
    }

    public static void main(String[] args) {
        String sampleInput1 = "2[cv]";
        String sampleOutput1 = decodeString(sampleInput1);
        System.out.println(sampleOutput1);  // Output: "cvcv"

        String sampleInput2 = "3[b2[v]]L";
        String sampleOutput2 = decodeString(sampleInput2);
        System.out.println(sampleOutput2);  // Output: "bvvbvvbvvL"
    }
}
