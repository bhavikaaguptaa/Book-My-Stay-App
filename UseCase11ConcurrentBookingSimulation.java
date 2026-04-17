import java.util.LinkedList;
import java.util.Queue;

public class UseCase11ConcurrentBookingSimulation {

    static Queue<String> bookingQueue = new LinkedList<>();
    static int availableRooms = 2;

    public static synchronized void processBooking(String guestName) {

        if (availableRooms > 0) {

            availableRooms--;

            System.out.println(
                    guestName +
                    " booking confirmed. Rooms Left: "
                    + availableRooms
            );

        } else {

            System.out.println(
                    guestName +
                    " booking failed. No Rooms Available."
            );
        }
    }

    public static synchronized String getNextGuest() {

        if (!bookingQueue.isEmpty()) {
            return bookingQueue.poll();
        }

        return null;
    }

    public static void main(String[] args) throws InterruptedException {

        System.out.println("=================================");
        System.out.println(" Welcome to Book My Stay App ");
        System.out.println(" Hotel Booking System v11.0 ");
        System.out.println("=================================");

        bookingQueue.add("Diya");
        bookingQueue.add("Aarav");
        bookingQueue.add("Riya");
        bookingQueue.add("Kabir");

        Runnable task = () -> {

            while (true) {

                String guest = getNextGuest();

                if (guest == null) {
                    break;
                }

                processBooking(guest);
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("\nFinal Available Rooms: " + availableRooms);
    }
}