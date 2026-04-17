import java.util.*;

class Reservation {
    String guestName;
    String roomType;

    Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

public class UseCase6RoomAllocationService {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println(" Welcome to Book My Stay App ");
        System.out.println(" Hotel Booking System v6.0 ");
        System.out.println("=================================");

        Queue<Reservation> bookingQueue = new LinkedList<>();

        bookingQueue.add(new Reservation("Diya", "Single Room"));
        bookingQueue.add(new Reservation("Aarav", "Suite Room"));
        bookingQueue.add(new Reservation("Riya", "Double Room"));

        HashMap<String, Integer> inventory = new HashMap<>();
        inventory.put("Single Room", 2);
        inventory.put("Double Room", 1);
        inventory.put("Suite Room", 1);

        Set<String> allocatedRoomIds = new HashSet<>();

        HashMap<String, Set<String>> roomAllocations = new HashMap<>();

        while (!bookingQueue.isEmpty()) {

            Reservation request = bookingQueue.poll();

            int available = inventory.getOrDefault(request.roomType, 0);

            if (available > 0) {

                String roomId =
                        request.roomType.substring(0, 2).toUpperCase()
                        + (allocatedRoomIds.size() + 101);

                allocatedRoomIds.add(roomId);

                roomAllocations.putIfAbsent(request.roomType, new HashSet<>());
                roomAllocations.get(request.roomType).add(roomId);

                inventory.put(request.roomType, available - 1);

                System.out.println("Confirmed: "
                        + request.guestName
                        + " -> "
                        + request.roomType
                        + " | Room ID: "
                        + roomId);

            } else {

                System.out.println("Sorry "
                        + request.guestName
                        + ", no "
                        + request.roomType
                        + " available.");
            }
        }

        System.out.println("\nRemaining Inventory:");
        for (String type : inventory.keySet()) {
            System.out.println(type + " : " + inventory.get(type));
        }
    }
}