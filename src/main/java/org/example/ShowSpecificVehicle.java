package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;

public class ShowSpecificVehicle extends JFrame {
    HashMap<String, Tracker> trackerMap = AddVehicle.getLocationTracker();
    String VehicleDescription;
    String VehicleID;
    String location;
    Timestamp lastUpdateTime;

    public ShowSpecificVehicle() {
        // Frame initialization
        setTitle("Show Specific Vehicle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250); // Adjust size as needed

        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Label - Enter Vehicle ID
        JLabel enterVehicleIDLabel = new JLabel("Enter Vehicle ID:");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(enterVehicleIDLabel, c);

        // Text field - Vehicle ID
        JTextField vehicleIDTextField = new JTextField(20);
        c.gridx = 1;
        mainPanel.add(vehicleIDTextField, c);

        // Button - Search Vehicle
        JButton searchVehicleButton = new JButton("Search Vehicle");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 1;
        mainPanel.add(searchVehicleButton, c);

        // Labels - Vehicle Details
        JLabel vehicleNameLabel = new JLabel("Vehicle Name:");
        c.gridy = 2;
        mainPanel.add(vehicleNameLabel, c);

        JLabel vehicleDescriptionLabel = new JLabel("Description:");
        c.gridy = 3;
        mainPanel.add(vehicleDescriptionLabel, c);

        JLabel vehicleLocationLabel = new JLabel("Location:");
        c.gridy = 4;
        mainPanel.add(vehicleLocationLabel, c);

        JLabel vehicleTimeLabel = new JLabel("Last Updated:");
        c.gridy = 5;
        mainPanel.add(vehicleTimeLabel, c);

        JLabel vehicleNameValueLabel = new JLabel();
        c.gridx = 1;
        c.gridy = 2;
        mainPanel.add(vehicleNameValueLabel, c);

        JLabel vehicleDescriptionValueLabel = new JLabel();
        c.gridy = 3;
        mainPanel.add(vehicleDescriptionValueLabel, c);

        JLabel vehicleLocationValueLabel = new JLabel();
        c.gridy = 4;
        mainPanel.add(vehicleLocationValueLabel, c);

        JLabel vehicleTimeValueLabel = new JLabel();
        c.gridy = 5;
        mainPanel.add(vehicleTimeValueLabel, c);

        // Button - Close
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the ShowSpecificVehicle form
            }
        });
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 6;
        mainPanel.add(closeButton, c);

        // Add main panel to frame
        getContentPane().add(mainPanel);

        // Pack and set visible
        pack();
        setVisible(true);

        searchVehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the vehicle ID entered by the user
                VehicleID = vehicleIDTextField.getText();

                // Initialize not found message
                String notFoundMessage = "Vehicle not found";

                // Search for the vehicle in the trackerMap
                for (String key : trackerMap.keySet()) {
                    if (key.equals(VehicleID)) {
                        // If the vehicle is found, retrieve its details
                        Tracker tracker = trackerMap.get(key);
                        VehicleID = tracker.getVehicleID();
                        VehicleDescription = tracker.getVehicleDescription();
                        location = tracker.getCurrentLocation();
                        lastUpdateTime = tracker.getCurrentTimestamp();

                        // update the labels with the retrieved information
                        vehicleNameValueLabel.setText(VehicleID);
                        vehicleDescriptionValueLabel.setText(VehicleDescription);
                        vehicleLocationValueLabel.setText(location);
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String formattedTime = sdf.format(lastUpdateTime);
                        vehicleTimeValueLabel.setText(formattedTime);

                        // Reset notFoundMessage since the vehicle is found
                        notFoundMessage = null;

                        break; // Exit the loop after finding the vehicle
                    }
                }

                // Display not found message if applicable
                if (notFoundMessage != null) {
                    JOptionPane.showMessageDialog(null, notFoundMessage, "Not Found", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        new ShowSpecificVehicle();
    }
}
