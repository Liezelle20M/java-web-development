package com.demo.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.DatabaseConnection;
import com.demo.model.Car;

public class CarDao {

    public List<Car> getAllCars() throws SQLException {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT * FROM cars";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Car car = new Car(rs.getInt("id"), rs.getString("registration"), rs.getString("make"),
                                  rs.getString("model"), rs.getString("color"), rs.getInt("year"), rs.getDouble("price"));
                cars.add(car);
            }
        }
        return cars;
    }

    public List<Car> searchCars(String make, String model, int year) throws SQLException {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT * FROM cars WHERE make LIKE ? AND model LIKE ? AND year = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + make + "%");
            stmt.setString(2, "%" + model + "%");
            stmt.setInt(3, year);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Car car = new Car(rs.getInt("id"), rs.getString("registration"), rs.getString("make"),
                                      rs.getString("model"), rs.getString("color"), rs.getInt("year"), rs.getDouble("price"));
                    cars.add(car);
                }
                
            }
        }
        return cars;
    }
    public boolean addCar(Car car) throws SQLException {
        String sql = "INSERT INTO cars (registration, make, model, color, year, price) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, car.getRegistration());
            stmt.setString(2, car.getMake());
            stmt.setString(3, car.getModel());
            stmt.setString(4, car.getColor());
            stmt.setInt(5, car.getYear());
            stmt.setDouble(6, car.getPrice());
            return stmt.executeUpdate() > 0;
        }

    }


    public boolean deleteCar(int carid) throws SQLException {
        String sql = "DELETE FROM cars WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, carid);
            return stmt.executeUpdate() > 0;
        }
    }

}
