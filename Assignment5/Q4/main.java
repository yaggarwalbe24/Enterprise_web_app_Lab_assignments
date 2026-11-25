import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.Scanner;

public class EventManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter event name: ");
        String eventName = sc.nextLine();

        System.out.print("Enter event date (YYYY-MM-DD): ");
        LocalDate eventDate = LocalDate.parse(sc.nextLine());

        System.out.print("Enter event start time (HH:MM): ");
        LocalTime startTime = LocalTime.parse(sc.nextLine());

        System.out.print("Enter venue name (leave blank if unavailable): ");
        String venue = sc.nextLine();

        Optional<String> venueName = venue.isEmpty() ? Optional.empty() : Optional.of(venue);
        LocalTime endTime = startTime.plusHours(2);

        System.out.println("\n----- EVENT DETAILS -----");
        System.out.println("Event Name: " + eventName);
        System.out.println("Event Date: " + eventDate);
        System.out.println("Start Time: " + startTime);
        System.out.println("End Time: " + endTime);

        System.out.println("Venue: " + venueName.orElse("Venue not specified"));

        LocalDate today = LocalDate.now();
        if (eventDate.isAfter(today)) {
            System.out.println("Event Status: Upcoming");
        }
        else if (eventDate.isEqual(today)) {
            System.out.println("Event Status: Today");
        }
        else {
            System.out.println("Event Status: Past");
        }

        long daysRemaining = ChronoUnit.DAYS.between(today, eventDate);
        if (daysRemaining > 0) {
            System.out.println("Days Remaining: " + daysRemaining);
        }
        else if (daysRemaining == 0) {
            System.out.println("Days Remaining: Event is today!");
        }
        else {
            System.out.println("Days Remaining: Event has already passed.");
        }
        sc.close();
    }
}