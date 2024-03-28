package com.skytracks.skytracks;

import com.skytracks.skytracks.utils.ConnectionUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddFlightController implements Initializable {

    @FXML
    private TextField flightIdTextField;

    @FXML
    private TextField destinationTextField;

    @FXML
    private TextField departureTimeTextField;

    @FXML
    private TextField flightTimeTextField;

    @FXML
    private TextField costTextField;

    @FXML
    private TextField planeTypeTextField;

    @FXML
    private Button addButton;


    private Stage stage; // Reference to the stage

    public void setStage(Stage stage) {
        this.stage = stage;
    }



    @FXML
    private void handleAddButtonAction() {
        String flightId = flightIdTextField.getText();
        String destination = destinationTextField.getText();
        String departureTime = departureTimeTextField.getText();
        String flightTime = flightTimeTextField.getText();
        String cost = costTextField.getText();
        String planeType = planeTypeTextField.getText();


        // SQL query to insert flight details
        String query = "INSERT INTO flights (flightID, destination, departure, flightTime, cost, planeType, status) VALUES (?, ?, ?, ?, ?, ?,?)";

        try (Connection conn = ConnectionUtil.conDB();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setString(1, flightId);
            preparedStatement.setString(2, destination);
            preparedStatement.setString(3, departureTime);
            preparedStatement.setString(4, flightTime);
            preparedStatement.setString(5, cost);
            preparedStatement.setString(6, planeType);
            preparedStatement.setString(7, "Available");

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                stage.close();
                System.out.println("Flight details added successfully!");
            } else {
                System.err.println("Failed to add flight details!");
            }
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void handleCloseButtonAction() {
        // Close the popup
        stage.close();
    }
}
