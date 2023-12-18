public class FastExponentiation {

    public static void main(String[] args) {
        // Example usage
        long base = 2;
        long exponent = 10;
        long result = fastExponentiation(base, exponent);
        System.out.println(base + " ^ " + exponent + " = " + result);
    }

    // Function to calculate base^exponent using fast exponentiation
    static long fastExponentiation(long base, long exponent) {
        if (exponent == 0) {
            return 1;
        }

        long result = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result *= base;
            }
            base *= base;
            exponent /= 2;
        }

        return result;
    }
}
