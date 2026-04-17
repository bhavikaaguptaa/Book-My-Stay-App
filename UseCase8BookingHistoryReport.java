import java.util.*;

class Reservation {

    String reservationId;
    String guestName;
    String roomType;

    Reservation(String reservationId, String guestName, String roomType) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.roomType = roomType;
    }

    void display() {
        System.out.println(
                reservationId + " | " +
                guestName + " | " +
                roomType
        );
    }
}

public class UseCase8BookingHistoryReport {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println(" Welcome to Book My Stay App ");
        System.out.println(" Hotel Booking System v8.0 ");
        System.out.println("=================================");

        List<Reservation> bookingHistory = new ArrayList<>();

        bookingHistory.add(new Reservation("RES101", "Diya", "Single Room"));
        bookingHistory.add(new Reservation("RES102", "Aarav", "Suite Room"));
        bookingHistory.add(new Reservation("RES103", "Riya", "Double Room"));

        System.out.println("\nBooking History:\n");

        for (Reservation booking : bookingHistory) {
            booking.display();
        }

        System.out.println("\n===== Booking Summary =====");
        System.out.println("Total Confirmed Reservations: " + bookingHistory.size());
    }
}