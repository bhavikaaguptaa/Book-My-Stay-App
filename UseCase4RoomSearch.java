import java.util.HashMap;

abstract class Room {
    String type;
    double price;

    Room(String type, double price) {
        this.type = type;
        this.price = price;
    }

    void displayDetails() {
        System.out.println("Room Type : " + type);
        System.out.println("Price     : ₹" + price);
    }
}

class SingleRoom extends Room {
    SingleRoom() {
        super("Single Room", 2500);
    }
}

class DoubleRoom extends Room {
    DoubleRoom() {
        super("Double Room", 4000);
    }
}

class SuiteRoom extends Room {
    SuiteRoom() {
        super("Suite Room", 7500);
    }
}

class RoomInventory {

    private HashMap<String, Integer> inventory = new HashMap<>();

    RoomInventory() {
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 0);
        inventory.put("Suite Room", 2);
    }

    int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }
}

public class UseCase4RoomSearch {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println(" Welcome to Book My Stay App ");
        System.out.println(" Hotel Booking System v4.0 ");
        System.out.println("=================================");

        RoomInventory inventory = new RoomInventory();

        Room[] rooms = {
            new SingleRoom(),
            new DoubleRoom(),
            new SuiteRoom()
        };

        System.out.println("\nAvailable Rooms:\n");

        for (Room room : rooms) {

            if (inventory.getAvailability(room.type) > 0) {
                room.displayDetails();
                System.out.println("Available : " + inventory.getAvailability(room.type));
                System.out.println();
            }
        }
    }
}