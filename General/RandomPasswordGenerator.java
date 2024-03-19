import java.security.SecureRandom;

public class RandomPasswordGenerator {
    private static final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()-_=+";

    public static void main(String[] args) {
        int length = 12; // Change the length of the password as needed
        String password = generatePassword(length);
        System.out.println("Generated Password: " + password);
    }

    public static String generatePassword(int length) {
        StringBuilder password = new StringBuilder();
        SecureRandom random = new SecureRandom();

        // Ensure at least one character from each character set
        password.append(LOWERCASE_CHARS.charAt(random.nextInt(LOWERCASE_CHARS.length())));
        password.append(UPPERCASE_CHARS.charAt(random.nextInt(UPPERCASE_CHARS.length())));
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        password.append(SPECIAL_CHARS.charAt(random.nextInt(SPECIAL_CHARS.length())));

        // Fill the remaining length with random characters
        for (int i = 4; i < length; i++) {
            String characterSet = getRandomCharacterSet(random);
            password.append(characterSet.charAt(random.nextInt(characterSet.length())));
        }

        // Shuffle the password
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(length);
            char temp = password.charAt(i);
            password.setCharAt(i, password.charAt(randomIndex));
            password.setCharAt(randomIndex, temp);
        }

        return password.toString();
    }

    private static String getRandomCharacterSet(SecureRandom random) {
        int choice = random.nextInt(3);
        switch (choice) {
            case 0:
                return LOWERCASE_CHARS;
            case 1:
                return UPPERCASE_CHARS;
            case 2:
                return DIGITS;
            default:
                return SPECIAL_CHARS;
        }
    }
}
