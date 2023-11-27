public class SetIthBit {

    public static int setIthBit(int num, int i) {
        // Left shift 1 by i positions to create a mask with only the ith bit set
        int mask = 1 << i;

        // Use bitwise OR to set the ith bit
        return num | mask;
    }

    public static void main(String[] args) {
        int number = 10; // Replace with your integer
        int position = 2; // Replace with the bit position you want to set

        int result = setIthBit(number, position);

        System.out.println("Original number: " + number);
        System.out.println("Number after setting the " + position + "th bit: " + result);
    }
}
