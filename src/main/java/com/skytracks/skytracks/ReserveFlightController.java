package com.skytracks.skytracks;

import com.skytracks.skytracks.models.Flight;
import com.skytracks.skytracks.utils.ConnectionUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ReserveFlightController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private RadioButton firstClassRadioButton;

    @FXML
    private RadioButton businessClassRadioButton;

    @FXML
    private RadioButton economyClassRadioButton;

    @FXML
    private ComboBox<String> dropdownMenu;

    @FXML
    private Button cancelButton;

    @FXML
    private Button bookButton;

    @FXML
    private Label additionalChargesLabel;

    Flight flight;

    private ToggleGroup classToggleGroup;

    private Stage stage; // Reference to the stage

    String currentUser;

    public void setStage(Stage stage, Flight flight, String currentUser) {

        this.stage = stage;
        this.flight = flight;
        this.currentUser = currentUser;
    }



    @FXML
    private void handleCancelButtonAction() {
        stage.close();
    }

    @FXML
    private void handleBookButtonAction() {
        // Implement book button action
        addFlightToDatabase(flight);
    }

    public void addFlightToDatabase(Flight flight) {

        RadioButton selectedRadioButton = (RadioButton) classToggleGroup.getSelectedToggle();
        String selectedClass = selectedRadioButton.getText();

        String selectedRoute = dropdownMenu.getSelectionModel().getSelectedItem();



        // SQL query to insert flight details into the reserved table
        String query = "INSERT INTO reserved (flightID, email, destination, departure, flightTime, planeType,  cost, status, class, route) VALUES (?, ?, ?, ?, ?, ?,?, ?, ?, ?)";

        try (Connection conn = ConnectionUtil.conDB();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setString(1, flight.getFlightNumber());
            preparedStatement.setString(2, currentUser);
            preparedStatement.setString(3, flight.getDestination());
            preparedStatement.setString(4, flight.getDeparture());
            preparedStatement.setString(5, flight.getFlightTime());
            preparedStatement.setString(6, flight.getPlaneType());
            preparedStatement.setDouble(7, flight.getCost());
            preparedStatement.setString(8, flight.getStatus());
            preparedStatement.setString(9, selectedClass);
            preparedStatement.setString(10, selectedRoute);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Flight added to database successfully!");
                stage.close();
            } else {
                System.out.println("Failed to add flight to database!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialize toggle group
        classToggleGroup = new ToggleGroup();
        firstClassRadioButton.setToggleGroup(classToggleGroup);
        businessClassRadioButton.setToggleGroup(classToggleGroup);
        economyClassRadioButton.setToggleGroup(classToggleGroup);

        // Set default selection
        firstClassRadioButton.setSelected(true);

    }
}
