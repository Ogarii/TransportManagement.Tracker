package org.example;

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ListAllVehicles extends JFrame {
    HashMap<String, Tracker> trackerMap = AddVehicle.getLocationTracker();


    public ListAllVehicles() {
        // Frame initialization
        setTitle("List All Vehicles");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400); // Adjust size as needed

        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Table
        String[] columnNames = {"Vehicle Name", "Vehicle Description", "Location", "Time"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable vehicleTable = new JTable(tableModel);

        // Set info from the hashmap to the form
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // Format for time
        for (Map.Entry<String, Tracker> entry : trackerMap.entrySet()) {
            String vehicleName = entry.getKey();
            String vehicleDescription = entry.getValue().getVehicleDescription();
            String location = entry.getValue().getCurrentLocation(); // Assuming Tracker has getLocation()
            Date lastUpdateTime = entry.getValue().getCurrentTimestamp(); // Assuming Tracker has getLastUpdateTime()
            String formattedTime = sdf.format(lastUpdateTime);
            String[] rowData = {vehicleName, vehicleDescription, location, formattedTime};
            tableModel.addRow(rowData);
        }

        // Sample data (replace with logic to fetch actual vehicle data)
        String[] row1 = {"", "", "", ""};
        tableModel.addRow(row1);
        JScrollPane scrollPane = new JScrollPane(vehicleTable);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Button - Close
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the ListAllVehicles form
            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(closeButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add main panel to frame
        getContentPane().add(mainPanel);

        // Pack and set visible
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new ListAllVehicles();
    }
}