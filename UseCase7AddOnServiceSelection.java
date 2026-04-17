import java.util.*;

class Service {

    String serviceName;
    int price;

    Service(String serviceName, int price) {
        this.serviceName = serviceName;
        this.price = price;
    }
}

public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println(" Welcome to Book My Stay App ");
        System.out.println(" Hotel Booking System v7.0 ");
        System.out.println("=================================");

        String reservationId = "RES101";

        List<Service> selectedServices = new ArrayList<>();

        selectedServices.add(new Service("Breakfast", 500));
        selectedServices.add(new Service("Airport Pickup", 1200));
        selectedServices.add(new Service("Spa Access", 2000));

        Map<String, List<Service>> reservationServices = new HashMap<>();

        reservationServices.put(reservationId, selectedServices);

        int totalCost = 0;

        System.out.println("\nReservation ID: " + reservationId);
        System.out.println("Selected Add-On Services:\n");

        for (Service service : reservationServices.get(reservationId)) {

            System.out.println(service.serviceName + " - ₹" + service.price);
            totalCost += service.price;
        }

        System.out.println("\nTotal Additional Cost: ₹" + totalCost);
    }
}