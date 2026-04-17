import java.util.*;

public class UseCase10BookingCancellation {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println(" Welcome to Book My Stay App ");
        System.out.println(" Hotel Booking System v10.0 ");
        System.out.println("=================================");

        HashMap<String, Integer> inventory = new HashMap<>();
        inventory.put("Single Room", 1);
        inventory.put("Double Room", 0);
        inventory.put("Suite Room", 1);

        HashMap<String, String> confirmedBookings = new HashMap<>();
        confirmedBookings.put("RES101", "Double Room");

        Stack<String> rollbackRooms = new Stack<>();

        String cancelReservation = "RES101";

        if (confirmedBookings.containsKey(cancelReservation)) {

            String roomType = confirmedBookings.get(cancelReservation);

            rollbackRooms.push(cancelReservation);

            inventory.put(roomType, inventory.get(roomType) + 1);

            confirmedBookings.remove(cancelReservation);

            System.out.println("Cancellation Successful.");
            System.out.println("Reservation Cancelled: " + cancelReservation);
            System.out.println("Inventory Restored For: " + roomType);

        } else {

            System.out.println("Cancellation Failed. Reservation Not Found.");
        }

        System.out.println("\nRollback Stack: " + rollbackRooms);
        System.out.println("\nUpdated Inventory:");

        for (String room : inventory.keySet()) {
            System.out.println(room + " : " + inventory.get(room));
        }
    }
}