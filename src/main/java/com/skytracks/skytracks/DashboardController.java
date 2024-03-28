package com.skytracks.skytracks;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.skytracks.skytracks.models.*;
import com.skytracks.skytracks.repo.StaffRepository;
import com.skytracks.skytracks.utils.ConnectionUtil;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.*;
import java.util.*;

public class DashboardController implements Initializable {

    public Button btnAddStaff;
    public Pane pnlReport;
    public Pane pnlCargo;
    public AnchorPane pdfDisplayArea;
    public TabPane tabPane;
    public ComboBox comboBoxSelectTable;
    public ListView pdfFilesListView;
    public Pane pnlRoutes;
    public Button btnRoutes;
    public Button btnAddRoute;
    public VBox pnCargoItems;
    public VBox pnRouteItems;
    @FXML
    private VBox pnItems = null;

    @FXML
    private VBox pnStaffItems = null;

    @FXML
    private Button btnFlights;

    @FXML
    private Button btnAddFlight;
    
    @FXML
    private Button btnStaff;

    @FXML
    private Button btnCargo;


    @FXML
    private Button btnReport;

    @FXML
    private Button btnSettings;

    @FXML
    private Button btnSignout;

    @FXML
    private Pane pnlFlights;

    @FXML
    private Pane pnlStaff;

    @FXML
    private Pane pnlSettings;

    @Override



    public void initialize(URL location, ResourceBundle resources) {


        List<String> pdfFiles = getPDFFilesFromDirectory();
        // Create a list for Cargo objects
        List<Cargo> cargoList = generateRandomCargoList(5);


        for (int i = 0; i < cargoList.size(); i++) {
            try {
                // Load the FXML and inject the custom object
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Item_Cargo.fxml"));
                Node node = loader.load();
                CargoItemController cargoItemController = loader.getController();
                cargoItemController.setData(cargoList.get(i));


                // Apply mouse effects
                node.setOnMouseEntered(event -> node.setStyle("-fx-background-color : #005792"));
                node.setOnMouseExited(event -> node.setStyle("-fx-background-color : #ffffff"));

                pnCargoItems.getChildren().add(node);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }





        // Create a list for Route objects
        List<Route> routeList = generateRandomRouteList(5); // Change 5 to desired number of route objects

        for (int i = 0; i < routeList.size(); i++) {
            try {
                // Load the FXML and inject the custom object
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Item_Route.fxml"));
                Node node = loader.load();
                RouteItemController routeItemController = loader.getController();
                routeItemController.setData(routeList.get(i));


                // Apply mouse effects
                node.setOnMouseEntered(event -> node.setStyle("-fx-background-color : #005792"));
                node.setOnMouseExited(event -> node.setStyle("-fx-background-color : #ffffff"));

                pnRouteItems.getChildren().add(node);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        pdfFilesListView.getItems().addAll(pdfFiles);

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



        StaffRepository repo = new StaffRepository();
        Staff[]  staffList = repo.getStaffList().toArray(new Staff[0]);


        for (int i = 0; i < flightsList.size(); i++) {
            try {
                // Load the FXML and inject the custom object
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Item.fxml"));
                Node node = loader.load();
                ItemController itemController = loader.getController();
                itemController.setData(flightsList.get(i), "Admin");


                // Apply mouse effects
                node.setOnMouseEntered(event -> node.setStyle("-fx-background-color : #005792"));
                node.setOnMouseExited(event -> node.setStyle("-fx-background-color : #ffffff"));

                pnItems.getChildren().add(node);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        for (int i = 0; i < staffList.length; i++) {
            try {
                // Load the FXML and inject the custom object
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Item_Staff.fxml"));
                Node node = loader.load();
                ItemStaffController staffController = loader.getController();
                staffController.setData(staffList[i]);


                // Apply mouse effects
                node.setOnMouseEntered(event -> node.setStyle("-fx-background-color : #005792"));
                node.setOnMouseExited(event -> node.setStyle("-fx-background-color : #ffffff"));

                pnStaffItems.getChildren().add(node);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public void handleClicks(ActionEvent actionEvent) throws IOException {

        if (actionEvent.getSource() == btnFlights) {
            pnlFlights.setStyle("-fx-background-color : #ffffff");
            pnlFlights.toFront();
        }
        if(actionEvent.getSource()==btnStaff)
        {
            pnlStaff.setStyle("-fx-background-color : #ffffff");
            pnlStaff.toFront();
        }

        if(actionEvent.getSource()==btnSettings)
        {
            pnlSettings.setStyle("-fx-background-color : #ffffff");
            pnlSettings.toFront();
        }

        if(actionEvent.getSource()==btnRoutes)
        {
            pnlRoutes.setStyle("-fx-background-color : #ffffff");
            pnlRoutes.toFront();
        }



        if(actionEvent.getSource()==btnCargo)
        {
            pnlCargo.setStyle("-fx-background-color : #ffffff");
            pnlCargo.toFront();
        }


        if(actionEvent.getSource()==btnReport)
        {
            pnlReport.setStyle("-fx-background-color : #ffffff");
            pnlReport.toFront();
        }

        if(actionEvent.getSource() == btnAddFlight){
            // Load the popup content from an FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("add_flight_popup.fxml"));
            Parent popupContent = loader.load();


            // Create a new stage for the popup
            Stage popupStage = new Stage();
            popupStage.setTitle("Add Flight");
            popupStage.initStyle(StageStyle.TRANSPARENT); // Optionally set a transparent style

            // Set the stage to the controller
            AddFlightController controller = loader.getController();
            controller.setStage(popupStage);


            // Create a scene with optional fade-in effect
            Scene scene = new Scene(popupContent);
            scene.setFill(Color.TRANSPARENT); // Transparent background



            // Apply fade-in effect (optional)
            FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.5), popupContent);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.play();

            popupStage.setScene(scene);
            popupStage.showAndWait();

        }


        if(actionEvent.getSource() == btnAddStaff){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("add_staff_popup.fxml"));
            Parent popupContent = loader.load();
            System.err.println("Clidkeee");
            // Create a new stage for the popup
            Stage popupStage = new Stage();
            popupStage.setTitle("Add Staff");
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
            popupStage.showAndWait();
        }

        if(actionEvent.getSource()==btnSignout)
        {
            //TODO: Route to login page
        }
    }



    public void generatePdf() {
        String query = "SELECT name, email, address, role FROM staff";

        try (Connection con = ConnectionUtil.conDB();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("Reports/Report.pdf"));

            document.open();
            PdfPTable table = new PdfPTable(4); // 4 columns.

            table.addCell("Name");
            table.addCell("Email");
            table.addCell("Address");
            table.addCell("Role");

            while (rs.next()) {
                table.addCell(rs.getString("name"));
                table.addCell(rs.getString("email"));
                table.addCell(rs.getString("address"));
                table.addCell(rs.getString("role"));
            }

            document.add(table);
            document.close();

            Pagination pagination = new Pagination();
            PdfModel model = new PdfModel(Paths.get("C:/Users/abdul/IdeaProjects/Skytracks/StaffDetails.pdf"));
            pagination.setPageCount(model.numPages());
            pagination.setPageFactory(index -> new ImageView(model.getImage(index)));


            Tab pdfTab = new Tab("PDF Viewer");
            pdfTab.setContent(pagination);
            tabPane.getTabs().add(pdfTab);
            tabPane.getSelectionModel().select(pdfTab);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }


    @FXML
    private void onPdfFileClicked() {
        String selectedFileName = (String) pdfFilesListView.getSelectionModel().getSelectedItem();
        if (selectedFileName != null) {

            Pagination pagination = new Pagination();
            PdfModel model = new PdfModel(Paths.get("C:/Users/abdul/IdeaProjects/Skytracks/Reports/" + selectedFileName));
            pagination.setPageCount(model.numPages());
            pagination.setPageFactory(index -> new ImageView(model.getImage(index)));


            Tab pdfTab = new Tab("PDF Viewer");
            pdfTab.setContent(pagination);
            tabPane.getTabs().add(pdfTab);
            tabPane.getSelectionModel().select(pdfTab);
        }
    }


    private List<String> getPDFFilesFromDirectory() {
        List<String> pdfFiles = new ArrayList<>();
        File directory = new File("C:/Users/abdul/IdeaProjects/Skytracks/Reports");
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(".pdf"));
            if (files != null) {
                for (File file : files) {
                    pdfFiles.add(file.getName());
                }
            }
        } else {
            System.err.println("Directory not found!");
        }
        return pdfFiles;
    }



    public static List<Cargo> generateRandomCargoList(int numCargo) {
        List<Cargo> cargoList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < numCargo; i++) {
            String cargoID = "C" + random.nextInt(1000);
            String flightNumber = "FN" + random.nextInt(100);
            String nature = "Nature" + random.nextInt(5); // Assuming nature is a string description
            double weight = random.nextDouble() * 1000; // Random weight between 0 and 1000
            cargoList.add(new Cargo(cargoID, flightNumber, nature, weight));
        }
        return cargoList;
    }

    // Method to generate random Route objects
    public static List<Route> generateRandomRouteList(int numRoutes) {
        List<Route> routeList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < numRoutes; i++) {
            String flightNumberLabel = "FL" + random.nextInt(100);
            String destination = "Destination" + random.nextInt(10);
            String origin = "Origin" + random.nextInt(10);
            String duration = random.nextInt(24) + " hours " + random.nextInt(60) + " minutes";
            String aircraftType = "Aircraft" + random.nextInt(5); // Assuming aircraft type is a string description
            String pilot = "Pilot" + random.nextInt(20);
            routeList.add(new Route(flightNumberLabel, destination, origin, duration, aircraftType, pilot));
        }
        return routeList;
    }






}