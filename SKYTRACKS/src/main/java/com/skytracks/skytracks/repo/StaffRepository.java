package com.skytracks.skytracks.repo;

import com.skytracks.skytracks.models.Staff;
import com.skytracks.skytracks.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffRepository {
    public List<Staff> getStaffList() {
        String query = "SELECT email, name, address, role, password FROM staff";
        List<Staff> staffList = new ArrayList<>();
        try (Connection conn = ConnectionUtil.conDB();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Staff staff = new Staff(
                        rs.getString("email"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("role"),
                        rs.getString("password")
                );
                staffList.add(staff);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staffList;
    }
}
