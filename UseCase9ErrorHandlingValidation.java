import java.util.HashMap;

class InvalidBookingException extends Exception {

    InvalidBookingException(String message) {
        super(message);
    }
}

public class UseCase9ErrorHandlingValidation {

    static HashMap<String, Integer> inventory = new HashMap<>();

    public static void validateBooking(String roomType) throws InvalidBookingException {

        if (!inventory.containsKey(roomType)) {
            throw new InvalidBookingException("Invalid Room Type Entered.");
        }

        if (inventory.get(roomType) <= 0) {
            throw new InvalidBookingException("No Rooms Available For " + roomType);
        }
    }

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println(" Welcome to Book My Stay App ");
        System.out.println(" Hotel Booking System v9.0 ");
        System.out.println("=================================");

        inventory.put("Single Room", 2);
        inventory.put("Double Room", 0);
        inventory.put("Suite Room", 1);

        String requestedRoom = "Double Room";

        try {

            validateBooking(requestedRoom);

            System.out.println("Booking Confirmed For " + requestedRoom);

        } catch (InvalidBookingException e) {

            System.out.println("Booking Failed: " + e.getMessage());
        }

        System.out.println("\nSystem Running Safely...");
    }
}