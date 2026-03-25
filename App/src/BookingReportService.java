import java.util.List;

public class BookingReportService {

    public void generateReport(List<Reservation> bookings) {

        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        System.out.println("Booking History Report\n");

        int count = 1;

        for (Reservation r : bookings) {
            System.out.println("Booking " + count++);
            System.out.println("Guest: " + r.getGuestName());
            System.out.println("Room Type: " + r.getRoomType());
            System.out.println();
        }

        System.out.println("Total Bookings: " + bookings.size());
    }
}