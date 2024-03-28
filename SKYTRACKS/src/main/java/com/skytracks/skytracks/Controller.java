package com.skytracks.skytracks;

import com.skytracks.skytracks.models.Flight;
import com.skytracks.skytracks.utils.ConnectionUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private VBox pnItems = null;

    @FXML
    private Button btnFlights;


    @FXML
    private Button btnReservations;

    @FXML
    private Button btnSettings;

    @FXML
    private Button btnSignout;

    @FXML
    private Pane pnlFlights;

    @FXML
    private Pane pnlReservations;

    @FXML
    private Pane pnlSettings;

    String currentUser;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void handleClicks(ActionEvent actionEvent) {

        if (actionEvent.getSource() == btnFlights) {
            pnlFlights.setStyle("-fx-background-color : #ffffff");
            pnlFlights.toFront();
        }
        if(actionEvent.getSource()==btnReservations)
        {
            pnlReservations.setStyle("-fx-background-color : #ffffff");
            pnlReservations.toFront();
        }

        if(actionEvent.getSource()==btnSettings)
        {
            pnlSettings.setStyle("-fx-background-color : #ffffff");
            pnlSettings.toFront();
        }

        if(actionEvent.getSource()==btnSignout)
        {
           //TODO: Route to login page
        }
    }

    public void setCurrentUser(String email){
        this.currentUser = email;



        List<Flight> flightsList = new ArrayList<>();

        // SQL query to select flights
        String query = "SELECT * FROM flights";

        try (Connection conn = ConnectionUtil.conDB();
             PreparedStatement preparedStatement = conn.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String flightId = resultSet.getString("flightID");
                String destination = resultSet.getString("destination");
                String departureTime = resultSet.getString("departure");
                String flightTime = resultSet.getString("flightTime");
                int cost = resultSet.getInt("cost");
                String planeType = resultSet.getString("planeType");
                String status = resultSet.getString("status");

                Flight flight = new Flight(flightId, destination, departureTime, flightTime, cost, planeType, status);
                flightsList.add(flight);
            }

            // Convert List<Flight> to Flight[] array
            Flight[] myObjects = flightsList.toArray(new Flight[0]);

            // Print the flights (for testing)
            for (Flight flight : myObjects) {
                System.out.println(flight);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < flightsList.size(); i++) {
            try {
                // Load the FXML and inject the custom object
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Item.fxml"));
                Node node = loader.load();
                ItemController itemController = loader.getController();
                itemController.setData(flightsList.get(i), currentUser);
                System.out.println(currentUser + "CONTROLLER");


                // Apply mouse effects
                node.setOnMouseEntered(event -> node.setStyle("-fx-background-color : #005792"));
                node.setOnMouseExited(event -> node.setStyle("-fx-background-color : #ffffff"));

                pnItems.getChildren().add(node);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
