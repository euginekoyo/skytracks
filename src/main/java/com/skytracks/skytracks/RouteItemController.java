package com.skytracks.skytracks;


import com.skytracks.skytracks.models.Flight;
import com.skytracks.skytracks.models.Route;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RouteItemController implements Initializable {

    public Label originLabel;
    public Label pilot;
    @FXML
    private HBox itemRoute;

    @FXML
    private ImageView itemImage;

    @FXML
    private Label flightNumberLabel;

    @FXML
    private Label destinationLabel;

    @FXML
    private Label timeLabel;

    @FXML
    private Label durationLabel;

    @FXML
    private Label aircraftLabel;

    @FXML
    private Button activeButton;

    // Constructor to inject a custom object (if needed)


    // Methods for handling events and actions
    public void handleActiveButtonClick() {
        // Implement button click logic here
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        itemRoute.setOnMouseClicked(event -> {
            try {
                onItemFlightClick();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }

    public void setData(Route route) {
        flightNumberLabel.setText(route.getFlightNumber());
        destinationLabel.setText(route.getDestination());
        originLabel.setText(route.getOrigin());
        durationLabel.setText(route.getDuration());
        aircraftLabel.setText(route.getAircraftType());
        pilot.setText(route.getPilot());
    }


    public void onItemFlightClick() throws IOException {
        // Load the popup content from an FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("popup.fxml"));
        Parent popupContent = loader.load();

        // Create a new stage for the popup
        Stage popupStage = new Stage();
        popupStage.setTitle("Flight Details");
        popupStage.initStyle(StageStyle.TRANSPARENT); // Optionally set a transparent style

        // Create a scene with optional fade-in effect
        Scene scene = new Scene(popupContent);
        scene.setFill(Color.TRANSPARENT); // Transparent background

        // Apply fade-in effect (optional)
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.5), popupContent);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.play();

        popupStage.setScene(scene);
        popupStage.setTitle("Book a Flight");
        popupStage.showAndWait(); // Wait for the popup to close
        // popupStage.show();

    }

}

