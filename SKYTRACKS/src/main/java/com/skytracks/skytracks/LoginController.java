package com.skytracks.skytracks;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

import com.skytracks.skytracks.models.Flight;
import com.skytracks.skytracks.utils.ConnectionUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class LoginController implements Initializable {

    public Button btnSignup;
    public Pane pnlSignUp;
    public Pane pnlLogin;
    public Button btnGoToLogin;
    public TextField txtName;
    public TextField txtEmail;

    public TextField txtLEmail;
    public TextField txtCardNo;
    public TextField txtPassportNo;
    public TextField txtAddress;
    public PasswordField txtNewPassword;
    public PasswordField txtCPassword;
    public Label lblNewErrors;
    public Button btnNewSignin;
    @FXML
    private Label lblErrors;


    @FXML
    private TextField txtPassword;

    @FXML
    private Button btnSignin;

    Connection con = null;

    String currentUser;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @FXML
    public void handleButtonAction(MouseEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene;
        stage.close();
        if (event.getSource() == btnNewSignin) {
            if (signUp().equals("Success")) {
                try {

                    scene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Home.fxml"))));
                    stage.setScene(scene);
                    stage.show();

                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }

            }
        }

        if (event.getSource() == btnSignin) {


            switch (logIn()){
                case "ADMIN":
                    scene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Dashboard.fxml"))));
                    stage.setScene(scene);
                    stage.show();
                    break;
                case "STAFF":
                    scene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Staff.fxml"))));
                    stage.setScene(scene);
                    stage.show();
                case "CUSTOMERS":
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
                    Parent root = loader.load();
                    // Get the controller associated with the FXML file
                    Controller controller = loader.getController();
                    // Pass data to the controller

                    controller.setCurrentUser(currentUser);


                    scene = new Scene(root);
                    stage.setScene(scene);

                    stage.show();

            }

        }

        if (event.getSource() == btnSignup) {


            pnlSignUp.toFront();

        }
        if (event.getSource() == btnGoToLogin) {
            pnlLogin.toFront();

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if (con == null) {
            lblErrors.setTextFill(Color.TOMATO);
            lblErrors.setText("Server Error : Check");
        } else {
            lblErrors.setTextFill(Color.GREEN);
            lblErrors.setText("Server is up : Good to go");
        }
    }

    public LoginController() {
        con = ConnectionUtil.conDB();
    }



    private String logIn() {
        String tableFound = null;
        String email = txtLEmail.getText();
        currentUser = email;
        String password = txtPassword.getText();
        if(email.isEmpty() || password.isEmpty()) {
            setLblError(Color.TOMATO, "Empty credentials");
            tableFound = "Error";
        } else {


            try {

                // Check Table 1
                preparedStatement = con.prepareStatement("SELECT * FROM admin WHERE email = ? AND password = ?");
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    tableFound = "ADMIN";
                    return tableFound;
                }

                // Check Table 2
                preparedStatement = con.prepareStatement("SELECT * FROM customers WHERE email = ? AND password = ?");
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    tableFound = "CUSTOMERS";
                    return tableFound;
                }

                // Check Table 3
                preparedStatement = con.prepareStatement("SELECT * FROM staff WHERE email = ? AND password = ?");
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    tableFound = "STAFF";
                    return tableFound;
                }




                if (!resultSet.next()) {
                    setLblError(Color.TOMATO, "Enter Correct Email/Password");
                    tableFound = "Error";
                } else {
                    setLblError(Color.GREEN, "Login Successful..Redirecting..");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                tableFound = "Exception";

            }



        }


        return tableFound;
    }



    private String signUp() {
        String status = "Success";

        // Perform sign-up logic (e.g., insert user data into a database)
        // Replace the following placeholder code with your actual implementation

        // Example: Insert user data into a hypothetical 'users' table
        String sql = "INSERT INTO customers (email, address, name, card, passport, password) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, txtEmail.getText());
            preparedStatement.setString(2, txtAddress.getText());
            preparedStatement.setString(3, txtName.getText());
            preparedStatement.setString(4, txtCardNo.getText());
            preparedStatement.setString(5, txtPassportNo.getText());
            preparedStatement.setString(6, txtNewPassword.getText());

            preparedStatement.executeUpdate();

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 0) {
                setNewLblError(Color.TOMATO, "Sign-up failed");
                status = "Error";
            } else {
                setNewLblError(Color.GREEN, "Sign-up Successful!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            status = "Exception";
        }

        return status;
    }


    private void setLblError(Color color, String text) {
        lblErrors.setTextFill(color);
        lblErrors.setText(text);
        System.out.println(text);
    }

    private void setNewLblError(Color color, String text) {
        lblNewErrors.setTextFill(color);
        lblNewErrors.setText(text);
        System.out.println(text);

    }

}
