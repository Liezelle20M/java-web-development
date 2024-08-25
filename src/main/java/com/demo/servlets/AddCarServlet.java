package com.demo.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.database.CarDao;
import com.demo.model.Car;
import com.google.gson.Gson;

@WebServlet("/addCar")
public class AddCarServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private CarDao carDAO = new CarDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String registration = request.getParameter("registration");
        String make = request.getParameter("make");
        String model = request.getParameter("model");
        String color = request.getParameter("color");
        String yearStr = request.getParameter("year");
        String priceStr = request.getParameter("price");

        try {

            System.out.println("Received year: " + yearStr);
            System.out.println("Received price: " + priceStr);
            
            // Validate and parse year and price
            int year = Integer.parseInt(yearStr);
            double price = Double.parseDouble(priceStr);

            // Create Car object and add to database
            Car car = new Car(0, registration, make, model, color, year, price);
            boolean success = carDAO.addCar(car);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(new Gson().toJson(success ? "Car added successfully" : "Failed to add car"));
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(new Gson().toJson("Invalid number format for year or price."));
        } catch (SQLException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(new Gson().toJson("Database error: " + e.getMessage()));
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(new Gson().toJson("Server error: " + e.getMessage()));
        }
    }
}