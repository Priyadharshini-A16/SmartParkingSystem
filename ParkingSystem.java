import java.util.ArrayList;
import java.util.Scanner;

class Vehicle {
    String vehicleNumber;
    int hours;
    double fee;

    Vehicle(String vehicleNumber, int hours) {
        this.vehicleNumber = vehicleNumber;
        this.hours = hours;
        this.fee = calculateFee();
    }

    double calculateFee() {
        return hours * 20;
    }

    void display() {
        System.out.println("Vehicle Number : " + vehicleNumber);
        System.out.println("Parking Hours  : " + hours);
        System.out.println("Parking Fee    : Rs." + fee);
        System.out.println("---------------------------");
    }
}

public class ParkingSystem {

    static ArrayList<Vehicle> vehicles = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== SMART PARKING MANAGEMENT SYSTEM =====");
            System.out.println("1. Vehicle Entry");
            System.out.println("2. View Parked Vehicles");
            System.out.println("3. Total Revenue");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addVehicle();
                    break;

                case 2:
                    viewVehicles();
                    break;

                case 3:
                    calculateRevenue();
                    break;

                case 4:
                    System.out.println("Exiting System...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);
    }

    static void addVehicle() {

        System.out.print("Enter Vehicle Number: ");
        String number = sc.nextLine();

        System.out.print("Enter Parking Hours: ");
        int hours = sc.nextInt();

        Vehicle vehicle = new Vehicle(number, hours);
        vehicles.add(vehicle);

        System.out.println("Vehicle Added Successfully!");
    }

    static void viewVehicles() {

        if (vehicles.isEmpty()) {
            System.out.println("No Vehicles Parked.");
            return;
        }

        System.out.println("\n===== PARKED VEHICLES =====");

        for (Vehicle v : vehicles) {
            v.display();
        }
    }

    static void calculateRevenue() {

        double total = 0;

        for (Vehicle v : vehicles) {
            total += v.fee;
        }

        System.out.println("Total Revenue : Rs." + total);
    }
}
