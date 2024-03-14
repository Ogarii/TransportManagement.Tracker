package org.example;

import org.example.Tracker;
import java.io.IOException;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.UUID;
import org.example.transportTracker;
import javax.swing.*;

public class Main {

    public static HashMap<String, Tracker> locationTracker = new HashMap<>();


  public static void main(String[] args) throws IOException {
      // Create a new instance of the TransportTracker class
      transportTracker transportTracker = new transportTracker();
      // Make the TransportTracker form visible
      transportTracker.setVisible(true);

       /* boolean running = true;
        while (running) {


            System.out.print("Enter a number between 1 to 4: ");

            System.out.println("1  Enter VehicleID");
            System.out.println("2  Display Vehicle location");
            System.out.println("3  Enter RemoveVehicle");
            System.out.println("4  Exit");

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
                    System.out.print("Enter vehicle ID to remove: ");
                    String vehicleToRemove = scanner.nextLine();
                    removeVehicle(vehicleToRemove);
                    break;
                case 4:
                    System.out.println("Number is 4. Exiting....");
                    running = false;
                    break;

                default:
                    System.out.println("Number is neither 1, 2, nor 3");
            }
        }

        */
    }


    private static String generateSessionID() {
        return UUID.randomUUID().toString();

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
    public static void removeVehicle(String vehicleID) {
        if (locationTracker.containsKey(vehicleID)) {
            locationTracker.remove(vehicleID);
            System.out.println("Vehicle with ID '" + vehicleID + "' removed successfully.");
        } else {
            System.out.println("Vehicle with ID '" + vehicleID + "' not found.");
        }
    }
}
