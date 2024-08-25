package com.demo.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.database.CarDao;
import com.demo.model.Car;
import com.google.gson.Gson;

@WebServlet("/searchCars")
public class SearchCarServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
	private CarDao carDAO = new CarDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String make = request.getParameter("make");
        String model = request.getParameter("model");
        int year = Integer.parseInt(request.getParameter("year"));

        System.out.println("Received search request with make=" + make + ", model=" + model + ", year=" + year);


        try {
            List<Car> cars = carDAO.searchCars(make, model, year);
            String json = new Gson().toJson(cars);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

}
