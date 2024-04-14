import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BlackjackGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Blackjack!");

        // Initialize deck
        List<Integer> deck = new ArrayList<>();
        initializeDeck(deck);

        // Shuffle deck
        Collections.shuffle(deck);

        // Deal cards to player and dealer
        List<Integer> playerHand = new ArrayList<>();
        List<Integer> dealerHand = new ArrayList<>();
        dealCard(deck, playerHand);
        dealCard(deck, playerHand);
        dealCard(deck, dealerHand);
        dealCard(deck, dealerHand);

        // Display initial hands
        System.out.println("Your hand: " + playerHand);
        System.out.println("Dealer's hand: [" + dealerHand.get(0) + ", ?]");

        // Player's turn
        while (true) {
            System.out.print("Do you want to hit or stand? (h/s): ");
            String choice = scanner.next();
            if (choice.equalsIgnoreCase("h")) {
                dealCard(deck, playerHand);
                System.out.println("Your hand: " + playerHand);
                if (getHandValue(playerHand) > 21) {
                    System.out.println("Bust! You lose.");
                    break;
                }
            } else if (choice.equalsIgnoreCase("s")) {
                break;
            } else {
                System.out.println("Invalid choice. Please enter 'h' or 's'.");
            }
        }

        // Dealer's turn
        while (getHandValue(dealerHand) < 17) {
            dealCard(deck, dealerHand);
        }
        System.out.println("Dealer's hand: " + dealerHand);

        // Determine winner
        int playerValue = getHandValue(playerHand);
        int dealerValue = getHandValue(dealerHand);
        if (playerValue > 21 || (dealerValue <= 21 && dealerValue > playerValue)) {
            System.out.println("Dealer wins!");
        } else if (dealerValue > 21 || playerValue > dealerValue) {
            System.out.println("You win!");
        } else {
            System.out.println("It's a tie!");
        }

        scanner.close();
    }

    private static void initializeDeck(List<Integer> deck) {
        for (int i = 1; i <= 10; i++) {
            for (int j = 0; j < 4; j++) {
                deck.add(i);
            }
        }
    }

    private static void dealCard(List<Integer> deck, List<Integer> hand) {
        int card = deck.remove(0);
        hand.add(card);
    }

    private static int getHandValue(List<Integer> hand) {
        int value = 0;
        int numAces = 0;
        for (int card : hand) {
            if (card == 1) {
                numAces++;
            }
            value += Math.min(card, 10);
        }
        while (value <= 11 && numAces > 0) {
            value += 10;
            numAces--;
        }
        return value;
    }
}
