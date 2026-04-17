import java.io.*;
import java.util.HashMap;

public class UseCase12DataPersistenceRecovery {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println(" Welcome to Book My Stay App ");
        System.out.println(" Hotel Booking System v12.0 ");
        System.out.println("=================================");

        String fileName = "hotelData.txt";

        HashMap<String, Integer> inventory = new HashMap<>();
        inventory.put("Single Room", 2);
        inventory.put("Double Room", 1);
        inventory.put("Suite Room", 1);

        try {

            PrintWriter writer = new PrintWriter(new FileWriter(fileName));

            for (String room : inventory.keySet()) {
                writer.println(room + ":" + inventory.get(room));
            }

            writer.close();

            System.out.println("\nSystem State Saved Successfully.");

        } catch (Exception e) {

            System.out.println("\nError While Saving Data.");
        }

        HashMap<String, Integer> recoveredInventory = new HashMap<>();

        try {

            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(":");

                recoveredInventory.put(data[0], Integer.parseInt(data[1]));
            }

            reader.close();

            System.out.println("\nRecovered Inventory:");

            for (String room : recoveredInventory.keySet()) {
                System.out.println(room + " : " + recoveredInventory.get(room));
            }

        } catch (Exception e) {

            System.out.println("\nNo Previous Data Found. Starting Fresh.");
        }
    }
}