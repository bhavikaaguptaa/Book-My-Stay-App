import java.util.LinkedList;
import java.util.Queue;

class Reservation {

    String guestName;
    String roomType;

    Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    void display() {
        System.out.println("Guest: " + guestName + " | Requested Room: " + roomType);
    }
}

public class UseCase5BookingRequestQueue {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println(" Welcome to Book My Stay App ");
        System.out.println(" Hotel Booking System v5.0 ");
        System.out.println("=================================");

        Queue<Reservation> bookingQueue = new LinkedList<>();

        bookingQueue.add(new Reservation("Diya", "Single Room"));
        bookingQueue.add(new Reservation("Aarav", "Suite Room"));
        bookingQueue.add(new Reservation("Riya", "Double Room"));

        System.out.println("\nBooking Requests in Arrival Order:\n");

        for (Reservation request : bookingQueue) {
            request.display();
        }

        System.out.println("\nTotal Pending Requests: " + bookingQueue.size());
    }
}