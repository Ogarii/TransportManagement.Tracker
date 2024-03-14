package org.example;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

public class AddVehicle extends JFrame {
    private JTextField enterVehicleNameTextField,enterVehicleDescriptionTextField;
    public static HashMap<String, Tracker> locationTracker = new HashMap<>();


    public AddVehicle() {
        // Frame initialization
        setTitle("Add Vehicle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300); // Adjust size as needed

        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Labels
        JLabel enterVehicleNameLabel = new JLabel("Enter Vehicle Name:");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(enterVehicleNameLabel, c);

        JLabel enterVehicleDescriptionLabel = new JLabel("Enter Vehicle Description:");
        c.gridy = 1;
        mainPanel.add(enterVehicleDescriptionLabel, c);

        // Text fields
        enterVehicleNameTextField = new JTextField(20);
        c.gridx = 1;
        c.gridy = 0;
        mainPanel.add(enterVehicleNameTextField, c);

        enterVehicleDescriptionTextField = new JTextField(20);
        c.gridy = 1;
        mainPanel.add(enterVehicleDescriptionTextField, c);

        // Button - Add Vehicle
        JButton addVehicleButton = new JButton("Add Vehicle");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 2;
        mainPanel.add(addVehicleButton, c);

        // Add main panel to frame
        getContentPane().add(mainPanel);

        // Pack and set visible
        pack();
        setVisible(true);

        addVehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String vehicleID = enterVehicleNameTextField.getText();
                String vehicleDescription = enterVehicleDescriptionTextField.getText();
                String sessionID = generateSessionID();

                Tracker tracker = null;
                try {
                    tracker = new Tracker(vehicleID, vehicleDescription, sessionID);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                // Add the Strings to the HashMap
                locationTracker.put(vehicleID, tracker);
                locationTracker.put(vehicleDescription,tracker);

                //clear the text fields after adding to the HashMap
                enterVehicleNameTextField.setText("");
                enterVehicleDescriptionTextField.setText("");

                // Display a message to confirm addition
                JOptionPane.showMessageDialog(null, "Vehicle added successfully!");
            }
        });

    }
    private static String generateSessionID() {
        return UUID.randomUUID().toString();

    }
    //set getter to access map from other classes
    public static HashMap<String, Tracker> getLocationTracker() {
        return locationTracker;
    }

    public static void main(String[] args) {
        new AddVehicle();
    }
}