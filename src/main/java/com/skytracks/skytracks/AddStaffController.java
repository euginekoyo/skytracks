package com.skytracks.skytracks;


import com.skytracks.skytracks.utils.ConnectionUtil;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddStaffController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField roleField;

    @FXML
    private void handleAdd() throws SQLException {
        String name = nameField.getText();
        String email = emailField.getText();
        String address = addressField.getText();
        String role = roleField.getText();


        String sql = "INSERT INTO staff (name, email, address, role, password) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionUtil.conDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set parameters
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, address);
            pstmt.setString(4, role);
            pstmt.setString(5, "123456");

            // Execute the insert
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                // Successfully inserted
                System.out.println("Staff member added successfully.");
            } else {
                // Insertion failed
                System.out.println("An error occurred. Staff member not added.");
            }
        }

    }

    @FXML
    private void handleCancel() {
        // Close the popup or clear the fields
    }
}
