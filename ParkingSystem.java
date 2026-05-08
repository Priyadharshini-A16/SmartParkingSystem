import java.util.ArrayList;
import java.util.Scanner;

class Vehicle {
    private String ownerName;
    private String vehicleNumber;
    private int parkingSlot;
    private int hours;

    public Vehicle(String ownerName, String vehicleNumber, int parkingSlot, int hours) {
        this.ownerName = ownerName;
        this.vehicleNumber = vehicleNumber;
        this.parkingSlot = parkingSlot;
        this.hours = hours;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public int getParkingSlot() {
        return parkingSlot;
    }

    public int getHours() {
        return hours;
    }

    public int calculateBill() {
        return hours * 50; // ₹50 per hour
    }
}

public class SmartParkingManagementSystem {

    static ArrayList<Vehicle> parkedVehicles = new ArrayList<>();
    static int totalSlots = 10;

    public static void parkVehicle(Scanner sc) {

        if (parkedVehicles.size() >= totalSlots) {
            System.out.println("Parking Full!");
            return;
        }

        System.out.print("Enter Owner Name: ");
        String owner = sc.nextLine();

        System.out.print("Enter Vehicle Number: ");
        String number = sc.nextLine();

        int slot = parkedVehicles.size() + 1;

        System.out.print("Enter Parking Hours: ");
        int hours = sc.nextInt();
        sc.nextLine();

        Vehicle vehicle = new Vehicle(owner, number, slot, hours);
        parkedVehicles.add(vehicle);

        System.out.println("Vehicle Parked Successfully!");
        System.out.println("Allocated Slot: " + slot);
    }

    public static void viewVehicles() {

        if (parkedVehicles.isEmpty()) {
            System.out.println("No Vehicles Parked.");
            return;
        }

        System.out.println("\n--- Parked Vehicles ---");

        for (Vehicle v : parkedVehicles) {
            System.out.println("Owner Name   : " + v.getOwnerName());
            System.out.println("Vehicle No   : " + v.getVehicleNumber());
            System.out.println("Parking Slot : " + v.getParkingSlot());
            System.out.println("Hours        : " + v.getHours());
            System.out.println("Bill Amount  : ₹" + v.calculateBill());
            System.out.println("---------------------------");
        }
    }

    public static void removeVehicle(Scanner sc) {

        System.out.print("Enter Vehicle Number to Remove: ");
        String number = sc.nextLine();

        for (Vehicle v : parkedVehicles) {

            if (v.getVehicleNumber().equalsIgnoreCase(number)) {

                System.out.println("Vehicle Removed Successfully!");
                System.out.println("Total Bill: ₹" + v.calculateBill());

                parkedVehicles.remove(v);
                return;
            }
        }

        System.out.println("Vehicle Not Found.");
    }

    public static void showAvailableSlots() {
        System.out.println("Available Slots: " + (totalSlots - parkedVehicles.size()));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== SMART PARKING MANAGEMENT SYSTEM =====");
            System.out.println("1. Park Vehicle");
            System.out.println("2. View Parked Vehicles");
            System.out.println("3. Remove Vehicle");
            System.out.println("4. Show Available Slots");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    parkVehicle(sc);
                    break;

                case 2:
                    viewVehicles();
                    break;

                case 3:
                    removeVehicle(sc);
                    break;

                case 4:
                    showAvailableSlots();
                    break;

                case 5:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}
