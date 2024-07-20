package Day20;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first date (yyyy-mm-dd): ");
        LocalDate date1 = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter the second date (yyyy-mm-dd): ");
        LocalDate date2 = LocalDate.parse(scanner.nextLine());

        long daysBetween = ChronoUnit.DAYS.between(date1, date2);
        System.out.println("Days between: " + daysBetween);
    }
}

