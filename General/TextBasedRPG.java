import java.util.Scanner;

public class TextBasedRPG {
    private static Scanner scanner = new Scanner(System.in);
    private static int playerHealth = 100;
    private static int playerGold = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to the Text-Based RPG!");

        while (playerHealth > 0) {
            System.out.println("\nYou are in a room. What would you like to do?");
            System.out.println("1. Explore");
            System.out.println("2. Rest");
            System.out.println("3. Check Status");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    explore();
                    break;
                case 2:
                    rest();
                    break;
                case 3:
                    checkStatus();
                    break;
                case 4:
                    System.out.println("Exiting the game. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }

        System.out.println("Game Over! You have run out of health.");
    }

    private static void explore() {
        int encounterChance = (int) (Math.random() * 100) + 1;
        if (encounterChance <= 40) {
            System.out.println("You encountered an enemy!");
            int enemyHealth = (int) (Math.random() * 50) + 50;
            System.out.println("Enemy Health: " + enemyHealth);

            while (enemyHealth > 0) {
                System.out.println("\nWhat would you like to do?");
                System.out.println("1. Attack");
                System.out.println("2. Flee");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        int damageDealt = (int) (Math.random() * 20) + 10;
                        int damageTaken = (int) (Math.random() * 15) + 5;
                        enemyHealth -= damageDealt;
                        playerHealth -= damageTaken;
                        System.out.println("You dealt " + damageDealt + " damage to the enemy.");
                        System.out.println("You took " + damageTaken + " damage from the enemy.");
                        break;
                    case 2:
                        System.out.println("You fled from the enemy.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please choose a valid option.");
                }

                if (enemyHealth <= 0) {
                    System.out.println("You defeated the enemy!");
                    int goldFound = (int) (Math.random() * 50) + 10;
                    System.out.println("You found " + goldFound + " gold.");
                    playerGold += goldFound;
                }

                if (playerHealth <= 0) {
                    System.out.println("Game Over! You have run out of health.");
                    return;
                }
            }
        } else {
            System.out.println("You explore the room but find nothing.");
        }
    }

    private static void rest() {
        int healthRestored = (int) (Math.random() * 30) + 20;
        playerHealth = Math.min(100, playerHealth + healthRestored);
        System.out.println("You have rested and restored " + healthRestored + " health.");
    }

    private static void checkStatus() {
        System.out.println("Current Health: " + playerHealth);
        System.out.println("Current Gold: " + playerGold);
    }
}
