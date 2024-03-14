package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;
import java.sql.Timestamp;

public class Tracker {

    private String vehicleID;
    private String vehicleDescription;
    private String sessionID;
    private final Timestamp currentTimestamp;
    private final String currentLocation;

    Constants constants = new Constants();
    String APIKEY = constants.getAPIKEY();




    public Tracker(String vehicleID, String vehicleDescription, String sessionID) throws IOException, JSONException {
        this.vehicleID = vehicleID;
        this.vehicleDescription = vehicleDescription;
        this.sessionID = sessionID;

        // Get the current timestamp
        long currentTimeMillis = System.currentTimeMillis();
        this.currentTimestamp = new Timestamp(currentTimeMillis);

        // Get the current location
        String apiKey = APIKEY;
        String endpoint = "https://www.googleapis.com/geolocation/v1/geolocate?key=" + apiKey;
        URL url = new URL(endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);
        String payload = "{}";
        connection.getOutputStream().write(payload.getBytes());
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder responseBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            responseBuilder.append(line);
        }
        reader.close();
        JSONObject jsonResponse = new JSONObject(responseBuilder.toString());
        JSONObject location = jsonResponse.getJSONObject("location");
        double latitude = location.getDouble("lat");
        double longitude = location.getDouble("lng");
        this.currentLocation = "Latitude: " + latitude + ", Longitude: " + longitude;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getVehicleDescription() {
        return vehicleDescription;
    }

    public void setVehicleDescription(String vehicleDescription) {
        this.vehicleDescription = vehicleDescription;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public Timestamp getCurrentTimestamp() {
        return currentTimestamp;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }
}
