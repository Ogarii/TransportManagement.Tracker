package org.example;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class transportTracker extends JFrame {

    public transportTracker() {
      // Frame initialization
        setTitle("TRANSPORT VEHICLE TRACKER");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Title label
        JLabel titleLabel = new JLabel("Transport Vehicle Tracker", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(titleLabel, c);

        // Add Vehicle panel
        JPanel addVehiclePanel = new JPanel();
        addVehiclePanel.setBorder(new TitledBorder("Add Vehicle"));
        addVehiclePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton addVehicleButton = new JButton("Add Vehicle");
        addVehiclePanel.add(addVehicleButton);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        mainPanel.add(addVehiclePanel, c);

        // Show Vehicles panel
        JPanel showVehiclesPanel = new JPanel();
        showVehiclesPanel.setBorder(new TitledBorder("Show Vehicles"));
        showVehiclesPanel.setLayout(new GridLayout(2, 1));
        JButton showAllVehiclesButton = new JButton("All Vehicles");
        JButton showSpecificVehicleButton = new JButton("Specific Vehicle");
        showVehiclesPanel.add(showAllVehiclesButton);
        showVehiclesPanel.add(showSpecificVehicleButton);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 1;
        mainPanel.add(showVehiclesPanel, c);

        // Remove Vehicle panel
        JPanel removeVehiclePanel = new JPanel();
        removeVehiclePanel.setBorder(new TitledBorder("Remove Vehicle"));
        removeVehiclePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton removeVehicleButton = new JButton("Remove Vehicle");
        removeVehiclePanel.add(removeVehicleButton);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.gridx = 2;
        c.gridy = 1;
        mainPanel.add(removeVehiclePanel, c);

        // Add main panel to frame
        getContentPane().add(mainPanel);

        // Pack and set visible
        pack();
        setVisible(true);

        // Action Listeners
        addVehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddVehicle addVehicle = new AddVehicle();
                addVehicle.setVisible(true);

            }
        });


        showAllVehiclesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement functionality for showing all vehicles
                ListAllVehicles listAllVehicles = new ListAllVehicles();
                listAllVehicles.setVisible(true);
            }
        });

        showSpecificVehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement functionality for showing specific vehicle
                ShowSpecificVehicle showSpecificVehicle = new ShowSpecificVehicle();
                showSpecificVehicle.setVisible(true);
            }
        });

        removeVehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement functionality for removing a vehicle
                RemoveVehicle removeVehicle = new RemoveVehicle();
                removeVehicle.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        new transportTracker();
    }
}