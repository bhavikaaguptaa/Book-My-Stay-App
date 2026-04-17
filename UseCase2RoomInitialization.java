abstract class Room {
    String type;
    int beds;
    double price;

    Room(String type, int beds, double price) {
        this.type = type;
        this.beds = beds;
        this.price = price;
    }

    void displayDetails() {
        System.out.println("Room Type: " + type);
        System.out.println("Beds: " + beds);
        System.out.println("Price: ₹" + price);
    }
}

class SingleRoom extends Room {
    SingleRoom() {
        super("Single Room", 1, 2500);
    }
}

class DoubleRoom extends Room {
    DoubleRoom() {
        super("Double Room", 2, 4000);
    }
}

class SuiteRoom extends Room {
    SuiteRoom() {
        super("Suite Room", 3, 7500);
    }
}

public class UseCase2RoomInitialization {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println(" Welcome to Book My Stay App ");
        System.out.println(" Hotel Booking System v2.0 ");
        System.out.println("=================================");

        Room r1 = new SingleRoom();
        Room r2 = new DoubleRoom();
        Room r3 = new SuiteRoom();

        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        r1.displayDetails();
        System.out.println("Available Rooms: " + singleAvailable);
        System.out.println();

        r2.displayDetails();
        System.out.println("Available Rooms: " + doubleAvailable);
        System.out.println();

        r3.displayDetails();
        System.out.println("Available Rooms: " + suiteAvailable);
    }
}