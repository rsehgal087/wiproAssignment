package Day20;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the date and time (yyyy-MM-ddTHH:mm:ss): ");
        LocalDateTime localDateTime = LocalDateTime.parse(scanner.nextLine());

        System.out.print("Enter the source timezone (e.g., America/New_York): ");
        String sourceTimeZone = scanner.nextLine();

        System.out.print("Enter the target timezone (e.g., Europe/London): ");
        String targetTimeZone = scanner.nextLine();

        ZonedDateTime sourceZonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of(sourceTimeZone));
        ZonedDateTime targetZonedDateTime = sourceZonedDateTime.withZoneSameInstant(ZoneId.of(targetTimeZone));

        System.out.println("Source Time: " + sourceZonedDateTime);
        System.out.println("Target Time: " + targetZonedDateTime);
    }
}
