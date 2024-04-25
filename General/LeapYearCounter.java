import java.util.Scanner;

public class LeapYearCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the starting year of the century: ");
        int startYear = scanner.nextInt();

        int endYear = startYear + 100;
        int leapYearCount = 0;

        for (int year = startYear; year < endYear; year++) {
            if (isLeapYear(year)) {
                leapYearCount++;
            }
        }

        System.out.println("Number of leap years in the century: " + leapYearCount);

        scanner.close();
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
