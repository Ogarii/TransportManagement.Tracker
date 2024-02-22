package org.example;

import org.example.Tracker;
import java.io.IOException;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    public static HashMap<String, Tracker> locationTracker = new HashMap<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        boolean running = true;
        while (running) {


            System.out.print("Enter a number between 1 to 3: ");
            int choice;
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.println("Number is 1");
                    System.out.print("Enter vehicle ID (or type 'quit' to exit): ");
                    String vehicleID = scanner.nextLine();


                    System.out.print("Enter vehicle description: ");
                    String vehicleDescription = scanner.nextLine();

                    // Generate a unique session ID
                    String sessionID = generateSessionID();

                    // Create a new Tracker object
                    Tracker tracker = new Tracker(vehicleID, vehicleDescription, sessionID);

                    // Add the Tracker object to the HashMap
                    locationTracker.put(vehicleID, tracker);

                    break;
                case 2:
                    System.out.println("Number is 2");
                    DisplayInfo();
                    break;
                case 3:
                    System.out.println("Number is 3");
                    break;
                default:
                    System.out.println("Number is neither 1, 2, nor 3");
            }
        }
    }

    private static String generateSessionID() {
        return UUID.randomUUID().toString();
    }

    public static void UserInput() throws IOException {
        boolean continueInput = true;
        while (continueInput) {

            System.out.print("Enter vehicle ID (or type 'quit' to exit): ");
            String vehicleID = scanner.nextLine();

            if ("quit".equalsIgnoreCase(vehicleID)) {
                break; // Exit the loop if 'quit' is entered
            }

            System.out.print("Enter vehicle description: ");
            String vehicleDescription = scanner.nextLine();

            // Generate a unique session ID
            String sessionID = generateSessionID();

            // Create a new Tracker object
            Tracker tracker = new Tracker(vehicleID, vehicleDescription, sessionID);

            // Add the Tracker object to the HashMap
            locationTracker.put(vehicleID, tracker);

            // Prompt the user to enter another vehicle
            System.out.print("Enter another vehicle? (yes/no): ");
            String input = scanner.nextLine();
            if (!input.equalsIgnoreCase("yes")) {
                break; // Exit the loop if 'yes' is not entered
            }
        }
    }


    public static void DisplayInfo() {

        System.out.println("\nTracker Objects:");
        for (String key : locationTracker.keySet()) {
            Tracker tracker = locationTracker.get(key);
            System.out.println("Vehicle ID: " + tracker.getVehicleID());
            System.out.println("Vehicle Description: " + tracker.getVehicleDescription());
            System.out.println("Session ID: " + tracker.getSessionID());
            System.out.println("Current Timestamp: " + tracker.getCurrentTimestamp());
            System.out.println("Current Location: " + tracker.getCurrentLocation());
            System.out.println();
        }
    }
}
