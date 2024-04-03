import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String name;
    private double balance;

    public BankAccount(String accountNumber, String name) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = 0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit of $" + amount + " successful. Current balance: $" + balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " successful. Current balance: $" + balance);
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + name);
        System.out.println("Current Balance: $" + balance);
    }
}

public class BankAccountManagementSystem {
    private static Map<String, BankAccount> accounts = new HashMap<>();
    private static int accountCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nBank Account Management System");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Display Account Information");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    performTransaction("deposit");
                    break;
                case 3:
                    performTransaction("withdraw");
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    displayAccountInfo();
                    break;
                case 6:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void createAccount() {
        scanner.nextLine(); // Consume newline
        System.out.print("Enter account holder's name: ");
        String name = scanner.nextLine();
        accountCount++;
        String accountNumber = "ACC" + accountCount;
        BankAccount account = new BankAccount(accountNumber, name);
        accounts.put(accountNumber, account);
        System.out.println("Account created successfully. Account number: " + accountNumber);
    }

    private static void performTransaction(String transactionType) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.next();
        BankAccount account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }
        System.out.print("Enter amount to " + transactionType + ": ");
        double amount = scanner.nextDouble();
        if (transactionType.equals("deposit")) {
            account.deposit(amount);
        } else if (transactionType.equals("withdraw")) {
            account.withdraw(amount);
        }
    }

    private static void checkBalance() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.next();
        BankAccount account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }
        System.out.println("Current balance for account number " + accountNumber + ": $" + account.getBalance());
    }

    private static void displayAccountInfo() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.next();
        BankAccount account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }
        account.displayAccountInfo();
    }
}
