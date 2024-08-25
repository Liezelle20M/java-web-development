
package com.demo.database;

import com.demo.DatabaseConnection;
import com.demo.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public boolean registerUser(User user) throws SQLException {
        String sql = "INSERT INTO registration (username, password, email, first_name, last_name) VALUES (?, ?,?,?,?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user. getFirstName());
            stmt.setString(5, user.getLastName());
            return stmt.executeUpdate() > 0;
        }
    }

    public User loginUser(String username, String password) throws SQLException {
        String sql = "SELECT * FROM registration WHERE username = ? AND password = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new User(rs.getInt("user_id"), rs.getString("username"), rs.getString("password"),  rs.getString("email"),  rs.getString("first_name"),  rs.getString("last_name"));
                }
            }
        }
        return null;
    }
}