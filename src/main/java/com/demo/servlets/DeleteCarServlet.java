package com.demo.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.database.CarDao;
import com.google.gson.Gson;

@WebServlet("/deleteCar")
public class DeleteCarServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private CarDao carDAO = new CarDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String carIdStr = request.getParameter("id"); // Assuming ID is used for deletion

        try {
            // Log received parameters
            System.out.println("Received car ID: " + carIdStr);

            // Validate and parse car ID
            int carId = Integer.parseInt(carIdStr.trim());

            // Delete the car from the database
            boolean success = carDAO.deleteCar(carId);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(new Gson().toJson(success ? "Car deleted successfully" : "Failed to delete car"));
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(new Gson().toJson("Invalid number format for car ID."));
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
