package org.example;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class RemoveVehicle extends JFrame {
    private JTextField vehicleIDTextField;
    HashMap<String, Tracker> trackerMap = AddVehicle.getLocationTracker();


    public RemoveVehicle() {
        // Frame initialization
        setTitle("Remove Vehicle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200); // Adjust size as needed

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
        vehicleIDTextField = new JTextField(20);
        c.gridx = 1;
        c.gridy = 0;
        mainPanel.add(vehicleIDTextField, c);

        // Button to Remove Vehicle
        JButton removeVehicleButton = new JButton("Remove Vehicle");
        removeVehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement functionality to remove vehicle based on ID
                String VehicleID = vehicleIDTextField.getText();

                if (trackerMap.containsKey(VehicleID)) {
                    trackerMap.remove(VehicleID);

                } else {
                    JOptionPane.showMessageDialog(null, "No Such Vehicle");

                }

                // Confirmation+ Dialogue
                String message = "Are you sure you want to remove vehicle with ID " + vehicleIDTextField.getText() + "?";
                int confirmation = JOptionPane.showConfirmDialog(null, message, "Remove Confirmation", JOptionPane.YES_NO_OPTION);
                if (confirmation == JOptionPane.YES_OPTION) {
                    // Proceed with vehicle removal logic (show success message, handle errors)
                    JOptionPane.showMessageDialog(null, "Vehicle removed successfully!", "Removal Successful", JOptionPane.INFORMATION_MESSAGE);
                    // Clear the text field after successful removal
                    vehicleIDTextField.setText("");
                }
            }
        });
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 1;
        mainPanel.add(removeVehicleButton, c);

        // Button - Close
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the RemoveVehicle form
            }
        });
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 2;
        mainPanel.add(closeButton, c);

        // Add main panel to frame
        getContentPane().add(mainPanel);

        // Pack and set visible
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new RemoveVehicle();
    }
}